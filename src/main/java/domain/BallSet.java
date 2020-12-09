package domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BallSet {
	private Set<Integer> balls = new LinkedHashSet<>();

	public Set<Integer> getBalls() {
		return balls;
	}

	public void setBalls(Set<Integer> balls) {
		this.balls = balls;
	}

	public BallSet() {}

	public BallSet(List<Integer> balls) {
		for (int ball : balls) {
			this.balls.add(ball);
		}
	}

}
