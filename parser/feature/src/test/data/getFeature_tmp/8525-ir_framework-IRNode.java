/*
 * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
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

package compiler.lib.ir_framework;

import compiler.lib.ir_framework.driver.irmatching.IRMatcher;
import compiler.lib.ir_framework.shared.*;
import jdk.test.lib.Platform;
import sun.hotspot.WhiteBox;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides default regex strings that can be used in {@link IR @IR} annotations to specify IR constraints.
 * <p>
 * There are two types of default regexes:
 * <ul>
 *     <li><p>Standalone regexes: Use them directly.</li>
 *     <li><p>Composite regexes: Their names contain "{@code _OF}" and expect another string in a list in
 *            {@link IR#failOn()} and {@link IR#counts()}. They cannot be use as standalone regex and will result in a
 *            {@link TestFormatException} when doing so.</li>
 * </ul>
 *
 * @see IR
 */
public class IRNode {
    private static final String START = "(\\d+(\\s){2}(";
    private static final String MID = ".*)+(\\s){2}===.*";
    private static final String END = ")";
    private static final String COMPOSITE_PREFIX = "#PRE#"; // Prefix for regexes that require an additional user-defined string.
    private static final String IS_REPLACED = "#IS_REPLACED#"; // Is replaced by an additional user-defined string.
    private static final String STORE_OF_CLASS_POSTFIX = "(:|\\+)\\S* \\*" + END;
    private static final String LOAD_OF_CLASS_POSTFIX = "(:|\\+)\\S* \\*" + END;

    public static final String ALLOC = "(.*precise .*\\R((.*(?i:mov|xorl|nop|spill).*|\\s*|.*LGHI.*)\\R)*.*(?i:call,static).*wrapper for: _new_instance_Java" + END;
    public static final String ALLOC_OF = COMPOSITE_PREFIX + "(.*precise .*" + IS_REPLACED + ":.*\\R((.*(?i:mov|xorl|nop|spill).*|\\s*|.*LGHI.*)\\R)*.*(?i:call,static).*wrapper for: _new_instance_Java" + END;
    public static final String ALLOC_ARRAY = "(.*precise \\[.*\\R((.*(?i:mov|xor|nop|spill).*|\\s*|.*LGHI.*)\\R)*.*(?i:call,static).*wrapper for: _new_array_Java" + END;
    public static final String ALLOC_ARRAY_OF = COMPOSITE_PREFIX + "(.*precise \\[.*" + IS_REPLACED + ":.*\\R((.*(?i:mov|xorl|nop|spill).*|\\s*|.*LGHI.*)\\R)*.*(?i:call,static).*wrapper for: _new_array_Java" + END;

    public static final String CHECKCAST_ARRAY = "(((?i:cmp|CLFI|CLR).*precise \\[.*:|.*(?i:mov|or).*precise \\[.*:.*\\R.*(cmp|CMP|CLR))" + END;
    public static final String CHECKCAST_ARRAY_OF = COMPOSITE_PREFIX + "(((?i:cmp|CLFI|CLR).*precise \\[.*" + IS_REPLACED + ":|.*(?i:mov|or).*precise \\[.*" + IS_REPLACED + ":.*\\R.*(cmp|CMP|CLR))" + END;
    // Does not work on s390 (a rule containing this regex will be skipped on s390).
    public static final String CHECKCAST_ARRAYCOPY = "(.*((?i:call_leaf_nofp,runtime)|CALL,\\s?runtime leaf nofp|BCTRL.*.leaf call).*checkcast_arraycopy.*" + END;

    public static final String FIELD_ACCESS = "(.*Field: *" + END;

    public static final String STORE = START + "Store(B|C|S|I|L|F|D|P|N)" + MID + END;
    public static final String STORE_B = START + "StoreB" + MID + END; // Store to boolean is also mapped to byte
    public static final String STORE_C = START + "StoreC" + MID + END;
    public static final String STORE_I = START + "StoreI" + MID + END; // Store to short is also mapped to int
    public static final String STORE_L = START + "StoreL" + MID + END;
    public static final String STORE_F = START + "StoreF" + MID + END;
    public static final String STORE_D = START + "StoreD" + MID + END;
    public static final String STORE_P = START + "StoreP" + MID + END;
    public static final String STORE_N = START + "StoreN" + MID + END;
    public static final String STORE_VECTOR = START + "StoreVector" + MID + END;
    public static final String STORE_OF_CLASS = COMPOSITE_PREFIX + START + "Store(B|C|S|I|L|F|D|P|N)" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_B_OF_CLASS = COMPOSITE_PREFIX + START + "StoreB" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_C_OF_CLASS = COMPOSITE_PREFIX + START + "StoreC" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_I_OF_CLASS = COMPOSITE_PREFIX + START + "StoreI" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_L_OF_CLASS = COMPOSITE_PREFIX + START + "StoreL" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_F_OF_CLASS = COMPOSITE_PREFIX + START + "StoreF" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_D_OF_CLASS = COMPOSITE_PREFIX + START + "StoreD" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_P_OF_CLASS = COMPOSITE_PREFIX + START + "StoreP" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_N_OF_CLASS = COMPOSITE_PREFIX + START + "StoreN" + MID + "@\\S*" + IS_REPLACED + STORE_OF_CLASS_POSTFIX;
    public static final String STORE_OF_FIELD = COMPOSITE_PREFIX + START + "Store(B|C|S|I|L|F|D|P|N)" + MID + "@.*name=" + IS_REPLACED + ",.*" + END;

    public static final String LOAD = START + "Load(B|UB|S|US|I|L|F|D|P|N)" + MID + END;
    public static final String LOAD_B = START + "LoadB" + MID + END;
    public static final String LOAD_UB = START + "LoadUB" + MID + END; // Load from boolean
    public static final String LOAD_S = START + "LoadS" + MID + END;
    public static final String LOAD_US = START + "LoadUS" + MID + END; // Load from char
    public static final String LOAD_I = START + "LoadI" + MID + END;
    public static final String LOAD_L = START + "LoadL" + MID + END;
    public static final String LOAD_F = START + "LoadF" + MID + END;
    public static final String LOAD_D = START + "LoadD" + MID + END;
    public static final String LOAD_P = START + "LoadP" + MID + END;
    public static final String LOAD_N = START + "LoadN" + MID + END;
    public static final String LOAD_VECTOR = START + "LoadVector" + MID + END;
    public static final String LOAD_OF_CLASS = COMPOSITE_PREFIX + START + "Load(B|UB|S|US|I|L|F|D|P|N)" + MID + "@\\S*"+  IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_B_OF_CLASS = COMPOSITE_PREFIX + START + "LoadB" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_UB_OF_CLASS = COMPOSITE_PREFIX + START + "LoadUB" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_S_OF_CLASS = COMPOSITE_PREFIX + START + "LoadS" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_US_OF_CLASS = COMPOSITE_PREFIX + START + "LoadUS" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_I_OF_CLASS = COMPOSITE_PREFIX + START + "LoadI" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_L_OF_CLASS = COMPOSITE_PREFIX + START + "LoadL" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_F_OF_CLASS = COMPOSITE_PREFIX + START + "LoadF" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_D_OF_CLASS = COMPOSITE_PREFIX + START + "LoadD" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_P_OF_CLASS = COMPOSITE_PREFIX + START + "LoadP" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_N_OF_CLASS = COMPOSITE_PREFIX + START + "LoadN" + MID + "@\\S*" + IS_REPLACED + LOAD_OF_CLASS_POSTFIX;
    public static final String LOAD_OF_FIELD = COMPOSITE_PREFIX + START + "Load(B|C|S|I|L|F|D|P|N)" + MID + "@.*name=" + IS_REPLACED + ",.*" + END;
    public static final String LOAD_KLASS  = START + "LoadK" + MID + END;

    public static final String LOOP   = START + "Loop" + MID + END;
    public static final String COUNTEDLOOP = START + "CountedLoop\\b" + MID + END;
    public static final String COUNTEDLOOP_MAIN = START + "CountedLoop\\b" + MID + "main" + END;
    public static final String OUTERSTRIPMINEDLOOP = START + "OuterStripMinedLoop\\b" + MID + END;
    public static final String LONGCOUNTEDLOOP = START + "LongCountedLoop\\b" + MID + END;
    public static final String IF = START + "If\\b" + MID + END;

    public static final String CALL = START + "Call.*Java" + MID + END;
    public static final String CALL_OF_METHOD = COMPOSITE_PREFIX + START + "Call.*Java" + MID + IS_REPLACED + " " +  END;
    public static final String DYNAMIC_CALL_OF_METHOD = COMPOSITE_PREFIX + START + "CallDynamicJava" + MID + IS_REPLACED + " " + END;
    public static final String STATIC_CALL_OF_METHOD = COMPOSITE_PREFIX + START + "CallStaticJava" + MID + IS_REPLACED + " " +  END;
    public static final String TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*reason" + END;
    public static final String PREDICATE_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*predicate" + END;
    public static final String UNSTABLE_IF_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*unstable_if" + END;
    public static final String CLASS_CHECK_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*class_check" + END;
    public static final String NULL_CHECK_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*null_check" + END;
    public static final String NULL_ASSERT_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*null_assert" + END;
    public static final String RANGE_CHECK_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*range_check" + END;
    public static final String UNHANDLED_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*unhandled" + END;
    public static final String INTRINSIC_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*intrinsic" + END;
    public static final String DIV_BY_ZERO_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*div0_check" + END;
    // Does not work for VM builds without JVMCI like x86_32 (a rule containing this regex will be skipped without having JVMCI built).
    public static final String INTRINSIC_OR_TYPE_CHECKED_INLINING_TRAP = START + "CallStaticJava" + MID + "uncommon_trap.*intrinsic_or_type_checked_inlining" + END;

    public static final String SCOPE_OBJECT = "(.*# ScObj.*" + END;
    public static final String MEMBAR = START + "MemBar" + MID + END;
    public static final String MEMBAR_STORESTORE = START + "MemBarStoreStore" + MID + END;
    public static final String SAFEPOINT = START + "SafePoint" + MID + END;

    public static final String CMOVEI = START + "CMoveI" + MID + END;
    public static final String ABS_I = START + "AbsI" + MID + END;
    public static final String ABS_L = START + "AbsL" + MID + END;
    public static final String ABS_F = START + "AbsF" + MID + END;
    public static final String ABS_D = START + "AbsD" + MID + END;
    public static final String AND = START + "And(I|L)" + MID + END;
    public static final String AND_I = START + "AndI" + MID + END;
    public static final String AND_L = START + "AndL" + MID + END;
    public static final String XOR_I = START + "XorI" + MID + END;
    public static final String XOR_L = START + "XorL" + MID + END;
    public static final String LSHIFT = START + "LShift(I|L)" + MID + END;
    public static final String LSHIFT_I = START + "LShiftI" + MID + END;
    public static final String LSHIFT_L = START + "LShiftL" + MID + END;
    public static final String RSHIFT = START + "RShift(I|L)" + MID + END;
    public static final String RSHIFT_I = START + "RShiftI" + MID + END;
    public static final String RSHIFT_L = START + "RShiftL" + MID + END;
    public static final String URSHIFT = START + "URShift(B|S|I|L)" + MID + END;
    public static final String URSHIFT_I = START + "URShiftI" + MID + END;
    public static final String URSHIFT_L = START + "URShiftL" + MID + END;
    public static final String ADD = START + "Add(I|L|F|D|P)" + MID + END;
    public static final String ADD_I = START + "AddI" + MID + END;
    public static final String ADD_L = START + "AddL" + MID + END;
    public static final String ADD_VD = START + "AddVD" + MID + END;
    public static final String SUB = START + "Sub(I|L|F|D)" + MID + END;
    public static final String SUB_I = START + "SubI" + MID + END;
    public static final String SUB_L = START + "SubL" + MID + END;
    public static final String SUB_F = START + "SubF" + MID + END;
    public static final String SUB_D = START + "SubD" + MID + END;
    public static final String MUL = START + "Mul(I|L|F|D)" + MID + END;
    public static final String MUL_I = START + "MulI" + MID + END;
    public static final String MUL_L = START + "MulL" + MID + END;
    public static final String MUL_F = START + "MulF" + MID + END;
    public static final String DIV = START + "(NoOvf)?Div(I|L|F|D)" + MID + END;
    public static final String DIV_L = START + "(NoOvf)?DivL" + MID + END;
    public static final String CON_I = START + "ConI" + MID + END;
    public static final String CON_L = START + "ConL" + MID + END;
    public static final String CONV_I2L = START + "ConvI2L" + MID + END;
    public static final String CONV_L2I = START + "ConvL2I" + MID + END;
    public static final String POPCOUNT_L = START + "PopCountL" + MID + END;

    public static final String VECTOR_CAST_B2X = START + "VectorCastB2X" + MID + END;
    public static final String VECTOR_CAST_S2X = START + "VectorCastS2X" + MID + END;
    public static final String VECTOR_CAST_I2X = START + "VectorCastI2X" + MID + END;
    public static final String VECTOR_CAST_L2X = START + "VectorCastL2X" + MID + END;
    public static final String VECTOR_CAST_F2X = START + "VectorCastF2X" + MID + END;
    public static final String VECTOR_CAST_D2X = START + "VectorCastD2X" + MID + END;
    public static final String VECTOR_UCAST_B2X = START + "VectorUCastB2X" + MID + END;
    public static final String VECTOR_UCAST_S2X = START + "VectorUCastS2X" + MID + END;
    public static final String VECTOR_UCAST_I2X = START + "VectorUCastI2X" + MID + END;
    public static final String VECTOR_REINTERPRET = START + "VectorReinterpret" + MID + END;

    public static final String FAST_LOCK   = START + "FastLock" + MID + END;
    public static final String FAST_UNLOCK = START + "FastUnlock" + MID + END;

    /**
     * Called by {@link IRMatcher} to merge special composite nodes together with additional user-defined input.
     */
    public static List<String> mergeNodes(String[] nodes) {
        List<String> mergedNodes = new ArrayList<>();
        for (int i = 0; i < nodes.length; i += 2) {
            String node = nodes[i];
            if (node.startsWith(COMPOSITE_PREFIX)) {
                if (i + 1 == nodes.length) {
                    reportMissingCompositeValue(node, i);
                }
                // Replace placeholder with user defined string.
                node = node.substring(COMPOSITE_PREFIX.length()).replaceAll(IS_REPLACED, nodes[i + 1]);
            } else {
                i--; // No composite node, do not increment by 2.
            }
            mergedNodes.add(node);
        }
        return mergedNodes;
    }

    /**
     * Is default regex supported on current platform, used VM build, etc.?
     * Throws a {@link CheckedTestFrameworkException} if the default regex is unsupported.
     */
    public static void checkDefaultRegexSupported(String node) throws CheckedTestFrameworkException {
        switch (node) {
            case INTRINSIC_OR_TYPE_CHECKED_INLINING_TRAP -> {
                if (!WhiteBox.getWhiteBox().isJVMCISupportedByGC()) {
                    throw new CheckedTestFrameworkException("INTRINSIC_OR_TYPE_CHECKED_INLINING_TRAP is unsupported in builds without JVMCI.");
                }
            }
            case CHECKCAST_ARRAYCOPY -> {
                if (Platform.isS390x()) {
                    throw new CheckedTestFrameworkException("CHECKCAST_ARRAYCOPY is unsupported on s390.");
                }
            }
            // default: do nothing -> default regex is supported
        }
    }

    /**
     * Mapping from string variable value to string variable name for better error reporting.
     */
    private static void reportMissingCompositeValue(String node, int i) {
        String varName = switch (node) {
            case ALLOC_OF -> "ALLOC_OF";
            case ALLOC_ARRAY_OF -> "ALLOC_ARRAY_OF";
            case CHECKCAST_ARRAY_OF -> "CHECKCAST_ARRAY_OF";
            case STORE_OF_CLASS -> "STORE_OF_CLASS";
            case STORE_B_OF_CLASS -> "STORE_B_OF_CLASS";
            case STORE_C_OF_CLASS -> "STORE_C_OF_CLASS";
            case STORE_D_OF_CLASS -> "STORE_D_OF_CLASS";
            case STORE_F_OF_CLASS -> "STORE_F_OF_CLASS";
            case STORE_I_OF_CLASS -> "STORE_I_OF_CLASS";
            case STORE_L_OF_CLASS -> "STORE_L_OF_CLASS";
            case STORE_N_OF_CLASS -> "STORE_N_OF_CLASS";
            case STORE_P_OF_CLASS -> "STORE_P_OF_CLASS";
            case STORE_OF_FIELD -> "STORE_OF_FIELD";
            case LOAD_OF_CLASS -> "LOAD_OF_CLASS";
            case LOAD_B_OF_CLASS -> "LOAD_B_OF_CLASS";
            case LOAD_UB_OF_CLASS -> "LOAD_UB_OF_CLASS";
            case LOAD_D_OF_CLASS -> "LOAD_D_OF_CLASS";
            case LOAD_F_OF_CLASS -> "LOAD_F_OF_CLASS";
            case LOAD_I_OF_CLASS -> "LOAD_I_OF_CLASS";
            case LOAD_L_OF_CLASS -> "LOAD_L_OF_CLASS";
            case LOAD_N_OF_CLASS -> "LOAD_N_OF_CLASS";
            case LOAD_P_OF_CLASS -> "LOAD_P_OF_CLASS";
            case LOAD_S_OF_CLASS -> "LOAD_S_OF_CLASS";
            case LOAD_US_OF_CLASS -> "LOAD_US_OF_CLASS";
            case LOAD_OF_FIELD -> "LOAD_OF_FIELD";
            default -> throw new TestFrameworkException("Missing variable mapping for " + node);
        };
        TestFormat.fail("Must provide additional value at index " + (i + 1) + " right after " + varName);
    }
}
