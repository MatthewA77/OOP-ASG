import java.util.HashSet;

public class Player {
    public String name;
    public char symbol;
    public int moveCount = 0;
    public int playerMoves[] = new int[9];
    private int conditions[][] = {
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 1, 2},
        {3, 4, 5},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6},
    };
    /*
    * 0 1 2
    * 3 4 5
    * 6 7 8
    */
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        for (int i = 0; i < 9; i++) {
            playerMoves[i] = -1;
        }
    }

    boolean checkWinner() {
        HashSet<Integer> set = new HashSet<>();
        for (int num : playerMoves) {
            set.add(num);
        }

        System.out.println(set);

        int sameElem;
        for (int[] condition : conditions) {
            sameElem = 0;
            for (int index : condition) {
                if (set.contains(index)) {
                    sameElem++;
                }
            }
            if (sameElem == 3) return true;
        }
        return false;
    }

    void addMove(int index) {
        playerMoves[moveCount++] = index;
    }
}