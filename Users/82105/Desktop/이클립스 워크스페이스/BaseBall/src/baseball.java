import java.util.Random;
import java.util.Scanner;
public class baseball {
	private int loc3; // 세 번째 자리 수
	private int loc2; // 두 번째 자리 수
	private int loc1; // 첫 번째 자리 수
	private int Iloc3; // 세 번째 자리 수
	private int Iloc2; // 두 번째 자리 수
	private int Iloc1; // 첫 번째 자리 수
	private int Strike;
	private int Ball;
	private int Out;
	private int a;
	private int b;
	private int tryCount;
	private boolean flag;
	private int DeadLine;
	public baseball() {
		//1.정답값으로 난수를 생성
		setting();
		Rand();
		flag = true;
		
		//2.시도 횟수
			
		//3.스트라이크, 볼, 아웃을 나타내는 메소드를 구현
		CompareS();
		if(flag == false) {
			System.out.println("숫자 야구 게임이 종료되었습니다.");
		}	
	}
	public static void main(String[] args) {
		baseball play = new baseball();
	}
	
	public void Rand() {
		while(true) {
			Random rand = new Random();
			a = rand.nextInt(99)+900;
			
			loc3 = ((a % 1000) / 100);
			loc2 = ((a % 100) / 10);
			loc1 = ((a%10) / 1);
			
			if(loc3 != loc2 && loc2 != loc1 && loc3 != loc1) {
				break;
			}
		}
	}
	
	public void CompareS() {
		System.out.println("|1.      정답: 랜덤변수 확인하기     |"+"          " + "|2.        나가기        |");
		while(flag) {
			Scanner in = new Scanner(System.in);
			System.out.println("세자리 수를 입력하세요 : ");
			String text = in.nextLine();
			
			if(text.equals("1")) {
				System.out.println(loc3 +" "+loc2+" "+ loc1);
				continue;
			}else if(text.equals("2")) {
				flag = false;
				return;
			}else {
				b = Integer.parseInt(text);
			}
			tryCount++;
			
			Iloc3 = ((b % 1000) / 100);
			Iloc2 = ((b % 100) / 10);
			Iloc1 = ((b % 10) / 1);
			
			//첫번째 자리 비교
			if(Iloc1 == loc1) {
				Strike = Strike + 1;
			}else {
				if(Iloc1 == loc2) {
					Ball = Ball + 1;
				}else if(Iloc1 == loc3) {
					Ball = Ball + 1;
				}else {
					Out = Out + 1; // Out 카운트는 입력한 수를 가지고 랜덤번째 자리가 난수의 각 자리와 비교를 마치고 같은 경우가 없는 경우 센다. 즉, 3개가 되면 OUT 
				}
			}
			
			if(Iloc2 == loc2) {
				Strike = Strike + 1;
			}else {
				if(Iloc2 == loc1) {
					Ball = Ball + 1;
				}else if(Iloc2 == loc3) {
					Ball = Ball + 1;
				}else {
					Out = Out + 1;
				}
			}
			
			if(Iloc3 == loc3) {
				Strike = Strike + 1;
			}else {
				if(Iloc3 == loc1) {
					Ball = Ball + 1;
				}else if(Iloc3 == loc2) {
					Ball = Ball + 1;
				}else {
					Out = Out + 1;
				}
			}
			
			
			if(Out < 3) {
				if(Strike == 3) {
					System.out.println("-------------------------Home Run!!!-------------------------------");
					System.out.println("게임에서 승리하셨습니다.");
					System.out.println("시도 횟수 : "+tryCount+"번 만에 성공하셨습니다.");
					System.out.println(loc3 +" "+loc2+" "+ loc1);
					return;
				}
				System.out.println("시도 횟수 : "+tryCount);
				System.out.println("Strike : " + Strike +" "+"Ball : " + Ball +" "+"OUT : "+Out);
			}else {
				System.out.println("시도 횟수 : "+tryCount);
				System.out.println("OUT : "+Out+"개로 아웃입니다.");
			}
			//
			if(tryCount == DeadLine) {
				System.out.println("게임에서 패배하셨습니다.");
				return;
			}
			// 카운트 초기화
			Strike = 0;
			Ball = 0;
			Out = 0;
		}
	}
	public void setting() {
		Scanner input = new Scanner(System.in);
		System.out.print("시도 횟수 제한 설정 : ");
		DeadLine = input.nextInt();
		
	}
}

