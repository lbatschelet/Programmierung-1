package woche07;

public class LeagueTable {
    /**
    * Berechnet die Punkte fur jedes Team basierend auf einer
    * Tabelle mit den Anzahl Siegen, Unentschieden und Niederlagen
    */
    public static void main(String[] args) {
            
        final int POINTS_FOR_WIN = 3, POINTS_FOR_TIE = 1;

        Team[] teams = {
                        new Team("FC Foo"), new Team("FC Bar"),
                        new Team("AC Qoo"), new Team("SC Tar")
        };

        // Anzahl Siege, Unentschieden und Niederlagen der vier Teams
        int[][] results = { {1, 2, 0},
                            {2, 0, 1},
                            {1, 1, 1},
                            {1, 0, 2} };
        final int NUM_OF_TEAMS = results.length;
        int points;

        // Punkteberechnung
        for (int i = 0; i < NUM_OF_TEAMS; i++) {
            points = results[i][0] * POINTS_FOR_WIN;
            points += results[i][1] * POINTS_FOR_TIE;
            teams[i].addPoints(points);
        }

        for (int i = 0; i < NUM_OF_TEAMS; i++)
            System.out.println(teams[i]);
    }
}