package baseball;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    private List<Integer> answer = new ArrayList<>();
    private String guessedNumber = "";
    private int strike = 0;
    private int ball = 0;
    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void getNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        this.guessedNumber = Console.readLine();
        if(this.guessedNumber.length()!=3)
            throw new IllegalArgumentException();
    }
    public void printSuccessMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public int decideNextStep(){
        this.printSuccessMessage();
        String next = Console.readLine();
        if(Objects.equals(next, "1") || Objects.equals(next, "2"))
            return Integer.parseInt(next);
        else{
            throw new IllegalArgumentException();
        }
    }

    public void initValues(){
        this.strike = 0;
        this.ball = 0;
        this.answer = new ArrayList<>();
    }
    public void makeAnswer(){
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }
    public void checkStrike(){
        this.strike = 0;
        for (int i = 0; i < this.answer.size(); i++) {
            if(this.answer.indexOf(i)==this.guessedNumber.charAt(i)){
                this.strike++;
            }
        }
    }

    public void checkBall(){
        this.ball = 0;
        for (int i = 0; i < this.answer.size(); i++) {
            if(this.answer.contains(this.guessedNumber.charAt(i))){
                this.ball++;
            }
            this.ball -= this.strike;
        }
    }

    public void printGuessResult(){
        if(this.strike==0&&this.ball==0)
            System.out.println("낫싱");
        if (this.ball!=0) {
            System.out.printf("%d볼 ",this.ball);
        }
        if (this.strike!=0) {
            System.out.printf("%d스트라이크\n",this.strike);
        }
    }

    public boolean isSuccessed(){
        if(this.strike==3) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.makeAnswer();
        System.out.println(application.answer);
        application.makeAnswer();
        System.out.println(application.answer);
    }
}
