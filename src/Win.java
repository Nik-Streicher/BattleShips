class Win {

    boolean complete(char[][] board) {
        int counter = 0;
        for (char[] x : board) {
            for (char y : x) {
                if (y == '@')
                    counter++;
            }
        }
        return counter == 14;
    }
}
