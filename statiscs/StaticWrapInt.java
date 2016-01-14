
import java.util.IntSummaryStatistics;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class StaticWrapInt {
	private final List<Integer> list;
	private final IntSummaryStatistics sumary;

	public StaticWrapInt (List<Integer> list) {
		this.list = list;
		sumary = list.stream().mapToInt(n -> n).summaryStatistics();
	}

	public final IntSummaryStatistics getSumary() {
		return sumary;
	}

	public final double getMedian() {
		int esq = 0;
		int dir = this.list.size() - 1;
		int meio;
		meio = (esq + dir) / 2;
		return this.list.get(meio);
	}

	private double scaleToTwo(double value) {
		return new BigDecimal(value).setScale(2,RoundingMode.CEILING).doubleValue();
	}	

	public final double getDesvioPadrao() {
		double avg = sumary.getAverage();
		long size = this.list.size();
		long somatorio = this.list.stream().map(v -> v - (int) avg)
			.map(v -> v * v).mapToLong(v -> v).sum();
		double ds = Math.sqrt(((double) 1 / (size - 1)) * somatorio);
		return scaleToTwo(ds);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{\"media\":\"")
			.append(sumary.getAverage()).append("\",\n")
			.append("\"mediana\":\"").append(this.getMedian())
			.append("\",\n").append("\"desvio\":\"")
			.append(this.getDesvioPadrao()).append("\",\n")
			.append("\"max\":\"").append(sumary.getMax()).append("\",\n")
			.append("\"min\":\"").append(sumary.getMin()).append("\",\n")
			.append("\"quantidade\":\"").append(sumary.getCount())
			.append("\",\n").append("\"total\":\"").append(sumary.getSum())
			.append("\"}").toString();
	}
}
