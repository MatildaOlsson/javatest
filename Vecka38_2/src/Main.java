//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] tioTal = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        System.out.println(summa(tioTal));


    }

    public static int summa(int[] tioTal) {
        int sum = 0;
        if (tioTal.length != 10) {
            throw new ArrayIndexOutOfBoundsException("Numbers must be 10");
        }
        try {
            for (int i = 0; i < tioTal.length; i++) {
                sum += tioTal[i];
            }
            return sum;
        } catch (NullPointerException e) {
            System.out.println("Ingen input");
            return 0;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Din array måste innehålla 10 element");
            return 0;
        }

    }
}