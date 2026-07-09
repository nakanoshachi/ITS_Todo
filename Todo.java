
// Todo.java;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        String[] tasks = new String[100]; // タスク （最大100件）
        boolean[] done = new boolean[100]; //
        int count = 0; // 件数
        int[] priority = new int[100]; // 優先度　1=高 2=中 3=低
        Scanner sc = new Scanner(System.in);

        while (true) {
            // メニューを表示して番号を読む
            System.out.println("1:追加  2:一覧  3:完了  4:削除  5:編集  6:完了済み削除  7:並び替え  8:検索  0:終了");
            System.out.print("番号を入力 > ");
            int menu = sc.nextInt();
            if (menu == 0) {
                System.out.println("終了します。");
                break;
            } else if (menu == 1) {
                count = add(tasks, done, count, priority, sc);
            } else if (menu == 2) {
                list(tasks, done, count, priority);
            } else if (menu == 3) {
                complete(done, count, sc);
            } else if (menu == 4) {
                count = delete(tasks, done, count, priority, sc);
            } else if (menu == 5) {
                edit(tasks, count, sc);
            } else if (menu == 6) {
                deleteDone(tasks, done, count, priority);
            } else if (menu == 7) {
                sortUndone(tasks, done, count, priority);
            } else if (menu == 8) {
                search(tasks, count, sc);
            }
        }
    }

    // 追加
    static int add(String[] tasks, boolean[] done, int count, int[] priority, Scanner sc) {
        if (count == 100) {
            System.out.println("これ以上追加できません。（100件まで）");
            return count;
        }

        System.out.print("やること > ");
        String t = sc.next();
        if (t.equals("")) {
            System.out.println("空のタスクは追加できません。");
            return count;
        }

        System.out.print("優先度 > ");
        int p = sc.nextInt();
        if(p!=1&&p!=2&&p!=3){
            System.out.println("123いずれかの数を入力してください。");
            return count;
        }

        tasks[count] = t; // ヒント：入力した t を配列に入れる
        done[count] = false; // ヒント：追加した直後は未完了
        priority[count]=p;
        count++; // ヒント：件数を1増やす
        System.out.println("追加しました");
        return count;
    }

    // 一覧
    static void list(String[] tasks, boolean[] done, int count, int[] priority) {
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
                String p = "";
                if(priority[i]==1) p="高";
                if(priority[i]==2) p="中";
                if(priority[i]==3) p="低";
                System.out.println((i + 1) + ". [" + mark + "]" + tasks[i]+",優先度： "+ p);
            }
            System.out.println("未完了" + notDone + " 件 / 全 " + count + "件");
        }
    }

    // 完了
    static void complete(boolean[] done, int count, Scanner sc) {
        System.out.print("完了する番号 > ");
        int n = sc.nextInt();
        if (n >= 1 && n <= count) {
            if (done[n - 1] == false) {
                done[n - 1] = true;
                // ヒント：done の n-1 番目を完了にする
                System.out.println("完了にしました");
            } else {
                done[n - 1] = false;
                System.out.println("未完了にしました");
            }
        } else {
            System.out.println("その番号はありません");
        }
    }

    // 削除
    static int delete(String[] tasks, boolean[] done, int count, int[] priority, Scanner sc) {
        System.out.print("削除する番号 > ");
        int n = sc.nextInt();
        sc.nextLine();
        if (n >= 1 && n <= count) {
            for (int i = n - 1; i < count - 1; i++) { // ヒント：詰める範囲
                // ヒント：1つ後ろを前へ
                tasks[i] = tasks[i + 1];
                done[i] = done[i + 1];
                priority[i]=priority[i+1];
            }
            count--;
            System.out.println("削除しました");
        } else {
            System.out.println("その番号はありません");
        }
        return count;
        // ヒント：新しい count を返す
    }

    // 編集
    static void edit(String[] tasks, int count, Scanner sc) {
        System.out.print("編集する番号 > ");
        int n = sc.nextInt();
        if (n >= 1 && n <= count) {
            System.out.print("新しい内容 > ");
            tasks[n - 1] = sc.nextLine();
            System.out.println("変更しました");
        }
    }

    // 完了済み削除
    static int deleteDone(String[] tasks, boolean[] done, int count, int[] priority) {
        for (int i = count - 1; i >= 0; i--) {
            if (done[i] == true) {
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                    done[j] = done[j + 1];
                    priority[j]=priority[j+1];
                }
                count--;
            }
        }
        return count;
    }

    // 並び替え未完了上
    static void sortUndone(String[] tasks, boolean[] done, int count, int[] priority) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (done[j] == true && done[j + 1] == false) {
                    String ts = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = ts;

                    boolean dn = done[j];
                    done[j] = done[j + 1];
                    done[j + 1] = dn;

                    int pr = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = pr;
                }
            }
        }
    }

    // キーワード検索
    static void search(String[] tasks, int count, Scanner sc){
        System.out.print("検索語 > ");
        String key = sc.next();
        for(int i=0;i<count;i++){
            if(tasks[i].contains(key)){
                System.out.println((i+1)+". "+tasks[i]);
            }
        }
    }
}