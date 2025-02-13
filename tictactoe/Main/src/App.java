import java.util.Scanner;

public class App {
    char map[][] = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    
    void updateMap(int x, int y, char c) {
        map[y][x] = c;
    }
    
    void printMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean validMove(int x, int y) {
        if (x >= 3 || y >= 3 || x < 0 || y < 0) return false;
        return map[y][x] == '-';
    }
    
    public static int nextTurn(int turn) {
        return turn == 0 ? 1 : 0;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Player 1 name: ");
        String p1Name = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String p2Name = scanner.nextLine();
        
        Player player1 = new Player(p1Name, 'X');
        Player player2 = new Player(p2Name, 'O');

        int x = -1, y = -1;
        int turn = 0;
        int cur = 0;
        while (cur < 9) {
            clearScreen();
            app.printMap();
            if (player1.checkWinner()) {
                System.out.println(player1.name + " wins!");
                System.exit(0);
            } else if (player2.checkWinner()) {
                System.out.println(player2.name + " wins!");
                System.exit(0);
            }
            System.out.println("Player " + (turn + 1) + " move: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (!app.validMove(x, y)) {
                System.out.println("Not a valid move!");
                continue;
            }

            if (turn == 0) {
                player1.addMove(3 * y + x);
                app.updateMap(x, y, 'X');
            } else {
                player2.addMove(3 * y + x);
                app.updateMap(x, y, 'O');
            }
            turn = nextTurn(turn);
            cur++;
        }

        System.out.println("Draw!");
        scanner.close();
    }
}
