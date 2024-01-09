package BeAble;

public class Ai implements Thinkable {

    protected char op;

     public void setOp(char op) {
         this.op = op;
     }
     public char getOp() {
         return op;
     }

    @Override
    public int calculate(int a, int b) {
        int reasult = 0;
        switch (op) {
            case '+':
                reasult = a + b;
                break;
            case '-':
                reasult = a - b;
                break;
            case '/':
                reasult = a / b;
                break;
            case '*':
                reasult = a * b;
                break;
            default:
                reasult = -9999;
        }

        return 0;
    }

    @Override
    public void think() {
        System.out.println("학습된 정보를 수집해서 결정");
    }

    @Override
    public String beAble() {
        return "생각 가능";
    }

}
