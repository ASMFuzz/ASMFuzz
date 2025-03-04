/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

#include "precompiled.hpp"
#include "gc/shared/barrierSet.hpp"
#include "gc/shared/cardTable.hpp"
#include "gc/shared/cardTableBarrierSet.inline.hpp"
#include "gc/shared/collectedHeap.hpp"
#include "memory/universe.hpp"
#include "runtime/frame.inline.hpp"

frame JavaThread::pd_last_frame(bool forSignalHandler) {
  assert(has_last_Java_frame(), "must have last_Java_sp() when suspended");
  address pc = _anchor.last_Java_pc();
  if (pc == NULL) {
    pc = (address)(_anchor.last_Java_sp()[-1]);
  }
  return frame(_anchor.last_Java_sp(), _anchor.last_Java_fp(), pc, forSignalHandler);
}

void JavaThread::cache_global_variables() {
  BarrierSet* bs = BarrierSet::barrier_set();

  const bool allow_shared_alloc =
    Universe::heap()->supports_inline_contig_alloc();

  if (allow_shared_alloc) {
    _heap_top_addr = (address) Universe::heap()->top_addr();
  } else {
    _heap_top_addr = NULL;
  }

  if (bs->is_a(BarrierSet::CardTableBarrierSet)) {
    _card_table_base = (address) (barrier_set_cast<CardTableBarrierSet>(bs)->card_table()->byte_map_base());
  } else {
    _card_table_base = NULL;
  }

}

// For Forte Analyzer AsyncGetCallTrace profiling support - thread is
// currently interrupted by SIGPROF
bool JavaThread::pd_get_top_frame_for_signal_handler(frame* fr_addr,
  void* ucontext, bool isInJava) {
  assert(Thread::current() == this, "caller must be current thread");
  return pd_get_top_frame(fr_addr, ucontext, isInJava, false);
}

bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava) {
  return pd_get_top_frame(fr_addr, ucontext, isInJava, true);
}

bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler) {
  // If we have a last_Java_frame, then we should use it even if
  // isInJava == true.  It should be more reliable than ucontext info.
  if (has_last_Java_frame()) {
    *fr_addr = pd_last_frame(forSignalHandler);
    return true;
  }

  // Could be in a code section that plays with the stack, like
  // MacroAssembler::verify_heapbase()
  if (in_top_frame_unsafe_section()) {
    return false;
  }

  // At this point, we don't have a last_Java_frame, so
  // we try to glean some information out of the ucontext
  // if we were running Java code when SIGPROF came in.
  if (isInJava) {
    ucontext_t* uc = (ucontext_t*) ucontext;

    intptr_t* ret_fp;
    intptr_t* ret_sp;
    address addr = os::fetch_frame_from_context(uc, &ret_sp, &ret_fp);
    if (addr == NULL || ret_sp == NULL ) {
      // ucontext wasn't useful
      return false;
    }

    frame ret_frame(ret_sp, ret_fp, addr, forSignalHandler);
    if (!ret_frame.safe_for_sender(this)) {
#ifdef COMPILER2
      // C2 uses ebp as a general register see if NULL fp helps
      frame ret_frame2(ret_sp, NULL, addr, forSignalHandler);
      if (!ret_frame2.safe_for_sender(this)) {
        // nothing else to try if the frame isn't good
        return false;
      }
      ret_frame = ret_frame2;
#else
      // nothing else to try if the frame isn't good
      return false;
#endif /* COMPILER2 */
    }
    *fr_addr = ret_frame;
    return true;
  }

  // nothing else to try
  return false;
}
