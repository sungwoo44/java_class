package object.day5;



public class B03ScoreName {
    
    public static void main(String[] args) {
        // 학생 4명의 성적을 저장해보세요.
    Score momo = new Score();
    Score dahyeon = new Score();
    Score nayeon = new Score();
    Score ziwei = new Score();

    momo.setName("momo");
    momo.setGrade(1);
    momo.setJumsues(new int[]{50,30,40});
  

    dahyeon.setName("dahyeon");
    dahyeon.setGrade(1);
    dahyeon.setJumsues(new int[]{90,80,70});
    
    nayeon.setName("nayeon");
    nayeon.setGrade(2);
    nayeon.setJumsues(new int[]{50,50,30,30});
  

    ziwei.setName("ziwei");
    ziwei.setGrade(2);
    ziwei.setJumsues(new int[]{100,90,90,100});
  
    

    
    

    //1학년 2명(모모,다현)3과목 2학년 2명 (나연,쯔위)4과목
    //모모
    System.out.println("이름:"+momo.getName());
    System.out.println("총점:"+momo.sum());
    System.out.println("평균:"+momo.average());
    momo.printScore();

    //다현
    System.out.println("이름:"+dahyeon.getName());
    System.out.println("총점:"+dahyeon.sum());
    System.out.println("평균:"+dahyeon.average());
    dahyeon.printScore();

    //나연
    System.out.println("이름:"+nayeon.getName());
    System.out.println("총점:"+nayeon.sum());
    System.out.println("평균:"+nayeon.average());
    nayeon.printScore();

    //쯔위
    System.out.println("이름:"+ziwei.getName());
    System.out.println("총점:"+ziwei.sum());
    System.out.println("평균:"+ziwei.average());
    ziwei.printScore();

    }
}
