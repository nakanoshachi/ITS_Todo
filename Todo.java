
// Todo.java;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        String[] tasks = new String[100]; // タスク （最大100件）
        boolean[] done = new boolean[100]; //
        int count = 0; // 件数
        Scanner sc = new Scanner(System.in);
        while (true) {
            // メニューを表示して番号を読む
            int menu = sc.nextInt();
            if (menu == 0) {
                System.out.println("タスクはありません");
            } else if (menu == 1) {
                add(tasks[count], done[count], count, sc);
            } else if (menu == 2) {
                /* 一覧：第９回 */}
            // 3:完了 / 4:削除 は第10回
        }
    }

    static int add(String[] tasks, boolean[] done, int count, Scanner sc) {
        System.out.print("やること > ");
        String t = sc.nextLine();
        tasks[count] = t; // ヒント：入力した t を配列に入れる
        done[count] = false; // ヒント：追加した直後は未完了
        count++; // ヒント：件数を1増やす
        System.out.println("追加しました");
        return count + 1;
    }
}