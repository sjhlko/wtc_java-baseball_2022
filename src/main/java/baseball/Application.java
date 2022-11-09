package baseball;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> answer = new ArrayList<>();
    private String GuessedNumber = "";
    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void getNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        this.GuessedNumber = Console.readLine();
    }

    public void makeAnswer(){
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
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
