/**
 * The type Ball remover.
 * @author Daniel Levy ID:208150433
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game       the game
     * @param remainingB the remaining blocks
     */
    public BallRemover(GameLevel game, Counter remainingB) {
        this.game = game;
        this.remainingBalls = remainingB;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }

}
