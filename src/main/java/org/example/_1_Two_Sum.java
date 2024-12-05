package org.example;

import java.util.HashMap;

public class _1_Two_Sum {

        /*
        https://leetcode.com/problems/two-sum/description/
         */
        public static int[] twoSum(int[] nums, int target) {
            // Tạo một HashMap để lưu các giá trị đã duyệt và chỉ số tương ứng
            HashMap<Integer, Integer> map = new HashMap<>();

            // Duyệt qua từng phần tử trong mảng
            for (int i = 0; i < nums.length; i++) {
                // Tính phần bù cần tìm
                int complement = target - nums[i];

                // Kiểm tra nếu phần bù đã có trong HashMap
                if (map.containsKey(complement)) {
                    // Trả về mảng gồm chỉ số của phần bù và chỉ số hiện tại
                    return new int[] { map.get(complement), i };
                }

                // Nếu không tìm thấy, lưu giá trị hiện tại và chỉ số của nó vào HashMap
                map.put(nums[i], i);
            }

            // Nếu không tìm được, trả về một mảng rỗng (chỉ để đề phòng)
            throw new IllegalArgumentException("No solution found");
        }

        public static void main(String[] args) {
            // Ví dụ 1
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] result1 = twoSum(nums1, target1);
            System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

            // Ví dụ 2
            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            int[] result2 = twoSum(nums2, target2);
            System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");

            // Ví dụ 3
            int[] nums3 = {3, 3};
            int target3 = 6;
            int[] result3 = twoSum(nums3, target3);
            System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
        }

    }