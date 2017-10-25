package permethylationmasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
	
	public static void main(String args[]) {
		
		String proteinSequence;
		Scanner sc = new Scanner(System.in);
		List<String> peptideSequence = new ArrayList<String>();
		List<ArrayList<Double>> aminoPeptideMass = new ArrayList<ArrayList<Double>>();
		List<ArrayList<Double>> permethylatedPeptideMass = new ArrayList<ArrayList<Double>>();
		
		System.out.println("Please enter the Protein Sequence");
		proteinSequence = sc.next();
		sc.close();
		
		peptideSequence = ProteinToPeptide.getPeptideSequence(proteinSequence);
		aminoPeptideMass = ProteinToPeptide.getAminoPeptideMass(proteinSequence, 0);
		permethylatedPeptideMass = ProteinToPeptide.getAminoPeptideMass(proteinSequence, 1);
		
		System.out.println("Peptide Sequence is ");
		
		for (int i = 0; i < peptideSequence.size(); i++)
		
		{
			List<Double> tempAminoMass = new ArrayList<Double>();
			tempAminoMass.addAll(aminoPeptideMass.get(i));
			List<Double> tempPermethylatedMass = new ArrayList<Double>();
			tempPermethylatedMass.addAll(permethylatedPeptideMass.get(i));
			System.out.println();
			System.out.format("%50s", peptideSequence.get(i));
			System.out.print("\t" + tempAminoMass + "\t" + tempPermethylatedMass);
		}
	}
}
