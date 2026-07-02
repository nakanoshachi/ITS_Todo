
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
                /* 一覧：第９回 */}
            // 3:完了 / 4:削除 は第10回
        }
    }

    //追加
    static int add(String[] tasks, boolean[] done, int count, Scanner sc) {
        System.out.print("やること > ");
        String t = sc.nextLine();
        tasks[count] = t; // ヒント：入力した t を配列に入れる
        done[count] = false; // ヒント：追加した直後は未完了
        count++; // ヒント：件数を1増やす
        System.out.println("追加しました");
        return count + 1;
    }

    //一覧
    static void list(String[] tasks, boolean[] done, int count){
        if(count == 0){
            System.out.println("タスクはありません。");
        }else{
            for(int i=0;i<count;i++){
                String mark;
                if(done[i] == true){
                    mark = "✓";
                }else{
                    mark = " ";
                }System.out.println((i+1) + ". [" + mark + "]" + tasks[i]);
            }
        }
    }
}