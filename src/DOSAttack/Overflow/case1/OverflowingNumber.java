package DOSAttack.Overflow.case1;

public class OverflowingNumber {
    public static void main(String[] args) {
        System.out.println(enoughRoomToAddLine(100));
        System.out.println(enoughRoomToAddLine(2_000_000));
        System.out.println(enoughRoomToAddLine(Integer.MAX_VALUE));
    }

    public static boolean enoughRoomToAddLine(int requestedSize) {
        int maxLength = 1_000_000;
        String newLine = "END OF FILE";
        int newLineSize = newLine.length();
        return requestedSize + newLineSize < maxLength;
    }
}
