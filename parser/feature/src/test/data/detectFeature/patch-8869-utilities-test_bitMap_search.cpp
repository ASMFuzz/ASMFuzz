@@ -91,10 +91,152 @@ bool TestIteratorFn::do_bit(size_t offset) {
   return true;
 }
 
-static idx_t compute_expected(idx_t search_start,
-                              idx_t search_end,
-                              idx_t left_bit,
-                              idx_t right_bit) {
+static idx_t compute_search_bwd_expected(idx_t search_left,
+                                         idx_t search_right,
+                                         idx_t left_bit,
+                                         idx_t right_bit) {
+  if (search_right > right_bit) {
+    if (search_left <= right_bit) {
+      return right_bit;
+    } else {
+      return BitMap::NotFound;
+    }
+  } else if (search_right > left_bit) {
+    if (search_left <= left_bit) {
+      return left_bit;
+    } else {
+      return BitMap::NotFound;
+    }
+  } else {
+    return BitMap::NotFound;
+  }
+}
+
+#define PRINT_TESTCASE << " search_left " << search_left << " search_right " << search_right << " left " << left << " right " << right << " result " << result
+
+static void test_search_bwd_testcase(BitMap& test_ones,
+                                     idx_t search_left,
+                                     idx_t search_right,
+                                     idx_t left,
+                                     idx_t right,
+                                     bool aligned_left) {
+  idx_t result;
+  idx_t exp_result = compute_search_bwd_expected(search_left, search_right, left, right);
+
+  result = test_ones.get_prev_one_offset(search_left, search_right);
+  EXPECT_EQ(result, exp_result) PRINT_TESTCASE;
+
+  if (aligned_left) {
+    result = test_ones.get_prev_one_offset_aligned_left(search_left, search_right);
+    EXPECT_EQ(result, exp_result) PRINT_TESTCASE;
+  }
+}
+
+static void test_search_bwd_ranges(BitMap& test_ones, idx_t left, idx_t right) {
+  // Some trivial cases.
+  test_search_bwd_testcase(test_ones, left, right, left, right, false);
+  test_search_bwd_testcase(test_ones, right, right, left, right, false);
+  test_search_bwd_testcase(test_ones, left, left, left, right, false);
+
+    // Test searches with various start and end ranges.
+  for (size_t c_start = 0; c_start < search_nchunks; ++c_start) {
+    for (size_t o_start = 0; o_start < search_noffsets; ++o_start) {
+      idx_t start = c_start * search_chunk_size + search_offsets[o_start];
+      // Terminate start iteration if start is more than two full
+      // chunks beyond left.  There isn't anything new to learn by
+      // continuing the iteration, and this noticably reduces the
+      // time to run the test.
+      if (left + 2 * search_chunk_size < start) {
+        c_start = search_nchunks; // Set to limit to terminate iteration.
+        break;
+      }
+
+      for (size_t c_end = c_start; c_end < search_nchunks; ++c_end) {
+        for (size_t o_end = (c_start == c_end) ? o_start : 0;
+             o_end < search_noffsets;
+             ++o_end) {
+          idx_t end = c_end * search_chunk_size + search_offsets[o_end];
+          // Similarly to start and left, terminate end iteration if
+          // end is more than two full chunks beyond right.
+          if (right + 2 * search_chunk_size < end) {
+            c_end = search_nchunks; // Set to limit to terminate iteration.
+            break;
+          }
+          // Skip this chunk if right is much larger than max(left, start)
+          // and this chunk is one of many similar chunks in between,
+          // again to reduce testing time.
+          if (MAX2(start, left) + 2 * search_chunk_size < end) {
+            if (end + 2 * search_chunk_size < right) {
+              break;
+            }
+          }
+
+          ASSERT_LE(start, end);       // test bug if fail
+          ASSERT_LT(end, BITMAP_SIZE); // test bug if fail
+          bool aligned_left = search_offsets[o_start] == 0;
+
+          test_search_bwd_testcase(test_ones, start, end, left, right, aligned_left);
+          if (start < end) {
+            test_search_bwd_testcase(test_ones, start, MAX2(start, end - 1), left, right, aligned_left);
+          }
+        }
+      }
+    }
+  }
+}
+
+TEST(BitMap, search_bwd) {
+  CHeapBitMap test_ones(BITMAP_SIZE);
+
+  test_ones.clear_range(0, test_ones.size());
+
+  idx_t result = test_ones.get_prev_one_offset(0, test_ones.size());
+  EXPECT_EQ(result, BitMap::NotFound);
+
+  for (size_t c_left = 0; c_left < 2; ++c_left) {
+    for (size_t c_right = c_left;
+         c_right < search_nchunks;
+         (c_right == c_left + 1) ? c_right = search_nchunks -1 : ++c_right) {
+
+            // For each offset within the left chunk...
+      for (size_t o_left = 0; o_left < search_noffsets; ++o_left) {
+        // left is start of left chunk + offset.
+        idx_t left = c_left * search_chunk_size + search_offsets[o_left];
+
+        test_ones.set_bit(left);
+        EXPECT_TRUE(test_ones.at(left));
+
+        // For each offset within the right chunk and > left...
+        for (size_t o_right = (c_left == c_right) ? o_left + 1 : 0;
+             o_right < search_noffsets;
+             ++o_right) {
+          // right is start of right chunk + offset.
+          idx_t right = c_right * search_chunk_size + search_offsets[o_right];
+
+          // Install the right bit.
+          test_ones.set_bit(right);
+          EXPECT_TRUE(test_ones.at(right));
+
+          // Apply the test.
+          test_search_bwd_ranges(test_ones, left, right);
+
+          // Remove the right bit.
+          test_ones.clear_bit(right);
+          EXPECT_FALSE(test_ones.at(right));
+        }
+
+        // Remove the left bit.
+        test_ones.clear_bit(left);
+        EXPECT_FALSE(test_ones.at(left));
+      }
+    }
+  }
+}
+
+static idx_t compute_search_fwd_expected(idx_t search_start,
+                                         idx_t search_end,
+                                         idx_t left_bit,
+                                         idx_t right_bit) {
   idx_t expected = search_end;
   if (search_start <= left_bit) {
     if (left_bit < search_end) {
@@ -108,10 +250,10 @@ static idx_t compute_expected(idx_t search_start,
   return expected;
 }
 
-static void test_search_ranges(BitMap& test_ones,
-                               BitMap& test_zeros,
-                               idx_t left,
-                               idx_t right) {
+static void test_search_fwd_ranges(BitMap& test_ones,
+                                   BitMap& test_zeros,
+                                   idx_t left,
+                                   idx_t right) {
   // Test get_next_one_offset with full range of map.
   EXPECT_EQ(left, test_ones.get_next_one_offset(0));
   EXPECT_EQ(right, test_ones.get_next_one_offset(left + 1));
@@ -168,7 +310,7 @@ static void test_search_ranges(BitMap& test_ones,
           ASSERT_LE(start, end);       // test bug if fail
           ASSERT_LT(end, BITMAP_SIZE); // test bug if fail
 
-          idx_t expected = compute_expected(start, end, left, right);
+          idx_t expected = compute_search_fwd_expected(start, end, left, right);
 
           EXPECT_EQ(expected, test_ones.get_next_one_offset(start, end));
           EXPECT_EQ(expected, test_zeros.get_next_zero_offset(start, end));
@@ -179,7 +321,7 @@ static void test_search_ranges(BitMap& test_ones,
           }
 
           idx_t start2 = MIN2(expected + 1, end);
-          idx_t expected2 = compute_expected(start2, end, left, right);
+          idx_t expected2 = compute_search_fwd_expected(start2, end, left, right);
 
           EXPECT_EQ(expected2, test_ones.get_next_one_offset(start2, end));
           EXPECT_EQ(expected2, test_zeros.get_next_zero_offset(start2, end));
@@ -194,7 +336,7 @@ static void test_search_ranges(BitMap& test_ones,
   }
 }
 
-TEST(BitMap, search) {
+TEST(BitMap, search_fwd) {
   CHeapBitMap test_ones(BITMAP_SIZE);
   CHeapBitMap test_zeros(BITMAP_SIZE);
 
@@ -238,7 +380,7 @@ TEST(BitMap, search) {
           EXPECT_FALSE(test_zeros.at(right));
 
           // Apply the test.
-          test_search_ranges(test_ones, test_zeros, left, right);
+          test_search_fwd_ranges(test_ones, test_zeros, left, right);
 
           // Remove the right bit.
           test_ones.clear_bit(right);