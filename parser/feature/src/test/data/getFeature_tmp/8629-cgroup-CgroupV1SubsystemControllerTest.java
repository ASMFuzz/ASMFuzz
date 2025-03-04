/*
 * Copyright (c) 2022, Red Hat, Inc.
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
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jdk.internal.platform.cgroupv1.CgroupV1SubsystemController;

/*
 * @test
 * @key cgroups
 * @requires os.family == "linux"
 * @modules java.base/jdk.internal.platform.cgroupv1
 * @library /test/lib
 * @run junit/othervm CgroupV1SubsystemControllerTest
 */
public class CgroupV1SubsystemControllerTest {

    @Test
    public void testCgPathEqualsRoot() {
        String root = "/";
        String mountPoint = "/somemount";
        CgroupV1SubsystemController ctrl = new CgroupV1SubsystemController(root, mountPoint);
        ctrl.setPath("/");
        assertEquals(mountPoint, ctrl.path());
    }

    @Test
    public void testCgPathNonEmptyRoot() {
        String root = "/";
        String mountPoint = "/sys/fs/cgroup/memory";
        CgroupV1SubsystemController ctrl = new CgroupV1SubsystemController(root, mountPoint);
        String cgroupPath = "/subpath";
        ctrl.setPath(cgroupPath);
        String expectedPath = mountPoint + cgroupPath;
        assertEquals(expectedPath, ctrl.path());
    }

    @Test
    public void testCgPathSubstring() {
        String root = "/foo/bar/baz";
        String mountPoint = "/sys/fs/cgroup/memory";
        CgroupV1SubsystemController ctrl = new CgroupV1SubsystemController(root, mountPoint);
        String cgroupPath = "/foo/bar/baz/some";
        ctrl.setPath(cgroupPath);
        String expectedPath = mountPoint + "/some";
        assertEquals(expectedPath, ctrl.path());
    }

    @Test
    public void testCgPathParentMatch() {
        String root = "/user.slice/user-1000.slice/session-50.scope";
        String mountPoint = "/sys/fs/cgroup/memory";
        CgroupV1SubsystemController ctrl = new CgroupV1SubsystemController(root, mountPoint);
        String cgroupPath = "/user.slice/user-1000.slice/session-3.scope";
        ctrl.setPath(cgroupPath);
        String expectedPath = mountPoint + "/user.slice/user-1000.slice";
        assertEquals(expectedPath, ctrl.path());
    }

    @Test
    public void testCgPathFallbackToMountPoint() {
        String root = "/user.slice/user-1000.slice/session-50.scope";
        String mountPoint = "/sys/fs/cgroup/memory";
        CgroupV1SubsystemController ctrl = new CgroupV1SubsystemController(root, mountPoint);
        String cgroupPath = "/machine.slice/machine-1032.slice/session-3.scope";
        ctrl.setPath(cgroupPath);
        String expectedPath = mountPoint;
        assertEquals(expectedPath, ctrl.path());
    }
}
