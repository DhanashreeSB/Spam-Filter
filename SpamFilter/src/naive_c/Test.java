package naive_c;

import naive_c.Classifier;
import naive_c.NaiveBayes;

public class Test
{
	public static void main(String[] args)
	{
		NaiveBayes nb = new NaiveBayes();
		Classifier eval = new Classifier(nb);
		eval.Evaluate(true);
		System.out.println("Accuracy : " + eval.getAccuracy());
		System.out.println("Precision : " + eval.getPrecision());
		System.out.println("Recall : " + eval.getRecall());
		System.out.println("FMeasure : " + eval.getFMeasure());
	}
}