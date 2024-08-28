/*
 * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
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

#ifndef SHARE_GC_SHARED_FREELISTALLOCATOR_HPP
#define SHARE_GC_SHARED_FREELISTALLOCATOR_HPP

#include "memory/allocation.hpp"
#include "memory/padded.hpp"
#include "runtime/atomic.hpp"
#include "utilities/globalDefinitions.hpp"
#include "utilities/lockFreeStack.hpp"

class AbstractAllocator {
protected:
  ~AbstractAllocator() = default;
public:
  virtual void* allocate() = 0;

  virtual void deallocate(void* node) = 0;
};

// Allocation is based on a lock-free list of nodes. To reduce synchronization
// overhead on the free list between allocation and release calls, the released
// nodes are first placed on a pending list, then transferred to the free list in
// batches. While on the pending list, the nodes are not available for allocation.
// Actual allocation & deallocation of nodes are provided by AbstractAllocator.
class FreeListAllocator {
  // Desired minimum transfer batch size.  There is relatively little
  // importance to the specific number.  It shouldn't be too big, else
  // we're wasting space when the release rate is low.  If the release
  // rate is high, we might accumulate more than this before being
  // able to start a new transfer, but that's okay.
  const size_t _transfer_threshold;

  size_t transfer_threshold() const { return _transfer_threshold; }

  struct FreeNode {
    FreeNode* volatile _next;

    FreeNode() : _next (nullptr) { }

    FreeNode* next() { return Atomic::load(&_next); }

    FreeNode* volatile* next_addr() { return &_next; }

    void set_next(FreeNode* next) { Atomic::store(&_next, next); }
  };

  struct NodeList {
    FreeNode* _head;     // First node in list or nullptr if empty.
    FreeNode* _tail;     // Last node in list or nullptr if empty.
    size_t _entry_count; // Sum of entries in nodes in list.

    NodeList();

    NodeList(FreeNode* head, FreeNode* tail, size_t entry_count);
  };

  class PendingList {
    FreeNode* _tail;
    FreeNode* volatile _head;
    volatile size_t _count;

    NONCOPYABLE(PendingList);

  public:
    PendingList();
    ~PendingList() = default;

    // Add node to the list.  Returns the number of nodes in the list.
    // Thread-safe against concurrent add operations.
    size_t add(FreeNode* node);

    size_t count() const;

    // Return the nodes in the list, leaving the list empty.
    // Not thread-safe.
    NodeList take_all();
  };

  static FreeNode* volatile* next_ptr(FreeNode& node) { return node.next_addr(); }
  typedef LockFreeStack<FreeNode, &next_ptr> Stack;

  AbstractAllocator* _allocator;
  char _name[DEFAULT_CACHE_LINE_SIZE - sizeof(AbstractAllocator*)];  // Use name as padding.

#define DECLARE_PADDED_MEMBER(Id, Type, Name) \
  Type Name; DEFINE_PAD_MINUS_SIZE(Id, DEFAULT_CACHE_LINE_SIZE, sizeof(Type))
  DECLARE_PADDED_MEMBER(1, volatile size_t, _free_count);
  DECLARE_PADDED_MEMBER(2, Stack, _free_list);
  DECLARE_PADDED_MEMBER(3, volatile bool, _transfer_lock);
#undef DECLARE_PADDED_MEMBER

  volatile uint _active_pending_list;
  PendingList _pending_lists[2];

  void delete_list(FreeNode* list);

  NONCOPYABLE(FreeListAllocator);

public:
  FreeListAllocator(const char* name,
                    AbstractAllocator* allocator,
                    size_t transfer_threshold = 10);

  const char* name() const { return _name; }

  ~FreeListAllocator();

  size_t free_count() const;
  size_t pending_count() const;

  void* allocate();
  void release(void* node);

  // Free nodes in the allocator could have been allocated out of an arena.
  // Therefore, the nodes can be freed at once when entire arena is discarded
  // without running destructors for the individual nodes. In such cases, reset
  // method should be called before the ~FreeListAllocator(). Calling the reset
  // method on nodes not managed by an arena will leak the memory by just dropping
  // the nodes to the floor.
  void reset();
  bool try_transfer_pending();

  size_t mem_size() const {
    return sizeof(*this);
  }
};

#endif // SHARE_GC_SHARED_FREELISTALLOCATOR_HPP
