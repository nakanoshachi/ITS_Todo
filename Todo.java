
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
            System.out.println("1:追加  2:一覧  3:完了  4:削除  0:終了");
            System.out.print("番号を入力 > ");
            int menu = sc.nextInt();
            if (menu == 0) {
                System.out.println("終了します。");
                break;
            } else if (menu == 1) {
                count = add(tasks, done, count, sc);
            } else if (menu == 2) {
                list(tasks, done, count);
            } else if (menu == 3) {
                complete(done, count, sc);
            } else if (menu == 4) {
                count = delete(tasks, done, count, sc);
            }

        }
    }

    // 追加
    static int add(String[] tasks, boolean[] done, int count, Scanner sc) {
        if (count == 100){
            System.out.println("これ以上追加できません（100件まで）");
            return count;
        }
        System.out.print("やること > ");
        String t = sc.next();
        tasks[count] = t; // ヒント：入力した t を配列に入れる
        done[count] = false; // ヒント：追加した直後は未完了
        count++; // ヒント：件数を1増やす
        System.out.println("追加しました");
        return count;
    }

    // 一覧
    static void list(String[] tasks, boolean[] done, int count) {
        if (count == 0) {
            System.out.println("タスクはありません。");
        } else {
            int notDone = 0;
            for (int i = 0; i < count; i++) {
                String mark;
                if (done[i] == true) {
                    mark = "✓";
                } else {
                    mark = " ";
                    notDone++;
                }
                System.out.println((i + 1) + ". [" + mark + "]" + tasks[i]);
            }
            System.out.println("未完了" + notDone + " 件 / 全 " + count + "件");
        }
    }

    // 完了
    static void complete(boolean[] done, int count, Scanner sc) {
        System.out.print("完了する番号 > ");
        int n = sc.nextInt();
        if (n >= 1 && n <= count) {
            done[n - 1] = true;
            // ヒント：done の n-1 番目を完了にする
            System.out.println("完了にしました");
        } else {
            System.out.println("その番号はありません");
        }
    }

    // 削除
    static int delete(String[] tasks, boolean[] done, int count, Scanner sc) {
        System.out.print("削除する番号 > ");
        int n = sc.nextInt();
        sc.nextLine();
        if (n >= 1 && n <= count) {
            for (int i = n - 1; i < count-1; i++) { // ヒント：詰める範囲
                // ヒント：1つ後ろを前へ
                tasks[i] = tasks[i+1];
                done[i] = done[i+1];
            }
            count--;
            System.out.println("削除しました");
        } else {
            System.out.println("その番号はありません");
        }
        return count;
        // ヒント：新しい count を返す

    }
}