import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/java-2d-array/problem
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int max = 0;
        //k đại diện cho hàng 0->3 của mảng
        for (int k = 0; k <= 3; k++) {
            //i đại diện cho cột 0->3 mảng của hàng k
            for (int i = 0; i <= 3; i++) {
                //một đồng hồ cát có 3 hàng
                //hàng đầu và cuối có 3 ô
                //hàng giữa có 1 ở cột trung tâm
                //1 1 1
                //  2
                //3 3 3
                int temp = 0;
                //lấy tổng 3 giá trị của hàng k
                for (int j = i; j <= i + 2; j++) {
                    temp += arr.get(k).get(j);
                }
                //cộng thêm giá trị của hàng k+1, cột i+1
                //tức là hàng tiếp theo của hàng phía trên, dịch sang phải 1 ô
                temp += arr.get(k + 1).get(i + 1);
                //cộng thêm tổng 3 giá trị đầu tiên của hàng cuối
                for (int j = i; j <= i + 2; j++) {
                    temp += arr.get(k + 2).get(j);
                }
                //gán temp tìm được đầu tiên cho max,
                // vì nếu không làm như vậy khi temp đầu tiên là số âm sẽ < max=0
                // thì giá trị temp sẽ không gán cho max => bài toán bị sai
                if (k == 0 && i == 0) {
                    max = temp;
                }
                //nếu temp tìm được > max
                //gán max bằng temp
                if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.println(max);
        bufferedReader.close();
    }
}