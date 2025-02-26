public class CleanThisV1 {
    public static void main(String[] args) {

        int age = 3;
        boolean withAdult = true;
        boolean vip = true;
        boolean access = true;

        if (age > 18){
            System.out.println("Grünes Band");
        }else if (age >= 16 && age <= 18) {
            System.out.println("Gelbes Band");
        } else if (age >4  && withAdult) {
            System.out.println("Rotes Band");
        } else {
            access = false;
            System.out.println("Kein Eintritt");
        }

        if (vip && access){
            System.out.println("Goldenes Band");
        }


    }

}