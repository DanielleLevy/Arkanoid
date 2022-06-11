//208150433, Daniel Levy

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * this class run the game.
 */
public class Ass6Game {
    /**
     * the main method that run the game.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        AnimationRunner runner = new AnimationRunner();
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        for (int i = 0; i < args.length; i++) {
            //When the argument we got from the user is not a number that marks a level in the game:
            char tav = args[i].charAt(0);
            int numOfLevel = tav - '0';
            //Convert the number entered as an argument to one of the levels in the game:
            switch (numOfLevel) {
                case 1:
                    levels.add(new Level1());
                    break;
                case 2:
                    levels.add(new Level2());
                    break;
                case 3:
                    levels.add(new Level3());
                    break;
                case 4:
                    levels.add(new Level4());
                    break;
                case 5:
                    levels.add(new Level5());
                    break;
                case 6:
                    levels.add(new Level6());
                    break;
                default:
                    break;
            }
        }
        if (levels.isEmpty()) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            levels.add(new Level5());
            levels.add(new Level6());
        }
        GameFlow myGame = new GameFlow(runner, runner.getGui().getKeyboardSensor());
        myGame.runLevels(levels);
    }
}
