
import java.util.Arrays;
import java.util.Scanner;
public class lotto {
    public static void main(String[] args) {
        int gameCount;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.printf("구입할 Lotto 수를 입력하시오 (1~5):");
            gameCount = sc.nextInt();
            String [][] check = new String [gameCount][6];
            if (gameCount < 1 || gameCount > 5) continue;{
                System.out.println("--------------------------------");
                int [] winningLotto = new int[6];
                int [][] randomLotto = new int[gameCount][6];
                

                winningLotto[0] = (int)(Math.random() * 45) + 1;
                for(int i = 1; i < 6; i++){
                    int num = (int)(Math.random() * 45) + 1;
                    for(int j = 0; j < i; j++){
                        if (num == winningLotto[j]){
                            num = (int)(Math.random() * 45) + 1;
                            j = -1;
                        }
                    }
                    winningLotto[i] = num;
                }
                Arrays.sort(winningLotto);


                for (int i = 0; i < gameCount; i++){
                    randomLotto[i][0] = (int)(Math.random() * 45) + 1;
                    for (int j = 1; j < 6; j++){
                        int num_ = (int)(Math.random() * 45) + 1;
                        for(int k = 0; k < j; k++){
                            if (num_ == randomLotto[i][k]){
                                num_ = (int)(Math.random() * 45) + 1;
                                k = -1;
                            }
                        }
                        randomLotto[i][j] = num_;
                    }
                    Arrays.sort(randomLotto[i]);
                }

                // 당첨 확인
                for (int i = 0; i < gameCount; i++){
                    for (int j = 0; j < 6; j++){
                        boolean matched = false;
                        for(int k = 0; k < 6; k++){
                            if (randomLotto[i][j] == winningLotto[k]){
                                matched = true;
                                break;
                            }
                        }
                        if (matched){
                            check[i][j] = "O";
                        }
                        else{
                            check[i][j] = "X";
                        }
                    }
                }

                System.out.println("자동 생성 로또 번호");
                for (int i = 0; i < gameCount; i++){
                    System.out.printf("[%2d] ", i+1);
                    for (int j = 0; j < 6; j++){
                        System.out.printf("%2d ", randomLotto[i][j]);
                    }
                    System.out.println();
                }
                
                System.out.println("--------------------------------");
                System.out.printf("당첨번호:     ");
                for (int i = 0; i < 6; i++){
                    System.out.printf("%2d ", winningLotto[i]);
                }
                System.out.println("\n--------------------------------");
                
                for(int i = 0; i < gameCount; i++){
                    System.out.printf("당첨결과[%d]: ", i+1);
                    for(int j = 0; j < 6; j++){
                        System.out.printf("%2d ", randomLotto[i][j]);
                    }
                    System.out.println();
                    System.out.print("           ");
                    for(int j = 0; j < 6; j++){
                        System.out.printf("%2s ", check[i][j]);
                    }
                    System.out.printf("\n");
                    System.out.println("--------------------------------");
                }
                System.out.println("Lotto 게임 종료");
                break;
            }
        }
    }
}