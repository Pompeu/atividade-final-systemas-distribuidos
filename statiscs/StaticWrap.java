
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class StaticWrap {
	private final List<Number> list;
	private final DoubleSummaryStatistics sumary;
	private final String fileName;

	public StaticWrap (String fileName ,List<Number> list) {
		this.fileName = fileName.split("/")[2].toLowerCase();
		this.list = list;
		sumary = list.stream().mapToDouble(n -> n.doubleValue()).summaryStatistics();
	}

	public final DoubleSummaryStatistics getSumary() {
		return sumary;
	}

	public final double getMedian() {
		int esq = 0;
		int dir = this.list.size() - 1;
		int meio;
		meio = (esq + dir) / 2;
		return this.list.get(meio).doubleValue();
	}

	public final double getDesvioPadrao() {
		return scaleToTwo(Math.sqrt(getVariance()));
	}

	public final double getVariance(){
		double avg  = this.sumary.getAverage();
		double size = this.list.size();
		double var = this.list
			.stream()
			.mapToDouble(n -> Math.pow(n.doubleValue()-avg,2))
			.sum()/size;
		return scaleToTwo(var);
	}

	private double scaleToTwo(double value) {
		return new BigDecimal(value).setScale(2,RoundingMode.CEILING).doubleValue();
	}	

	@Override
	public String toString() {
		return new StringBuilder()
			.append("{\"title\":\"")
			.append(this.fileName).append("\",\n")
			.append("\"media\":\"")
			.append(scaleToTwo(sumary.getAverage())).append("\",\n")
			.append("\"variancia\":\"")
			.append(scaleToTwo(this.getVariance())).append("\",\n")
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
