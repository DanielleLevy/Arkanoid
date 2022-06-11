/**
 * The type Score tracking listener.
 * @author Daniel Levy
 * ID:208150433
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
@Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }

    /**
     * Gets current score.
     *
     * @return the current score
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}