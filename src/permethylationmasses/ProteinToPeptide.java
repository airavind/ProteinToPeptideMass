package permethylationmasses;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProteinToPeptide {
	
	public static ArrayList<String> getPeptideSequence(String proteinSequence) {
		// Get the peptide sequence based on trypsin enzyme.
		String regex = "[RK]";
		int start = 0;
		int end = 0;
		List<String> peptideSequence = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(proteinSequence);
		
		while (matcher.find()) {
			end = matcher.end();
			String temp = proteinSequence.substring(start, end);
			start = end;
			if (proteinSequence.charAt(end) == 'P') {
				matcher.find();
				end = matcher.end();
				String newTemp = temp + proteinSequence.substring(start, end);
				peptideSequence.add(newTemp);
				start = end;
			} // if
			else
				peptideSequence.add(temp);
		} // While
		end = proteinSequence.length();
		peptideSequence.add(proteinSequence.substring(start, end));
		
		return (ArrayList<String>) peptideSequence;
	}
	
	public static ArrayList<ArrayList<Double>> getAminoPeptideMass(String proteinSequence, int flag) {
		
		double current = 0;
		double mWeight = 18.0105646;
		List<String> peptideSequence = new ArrayList<String>();
		List<ArrayList<Double>> doubleResult = new ArrayList<ArrayList<Double>>();
		
		peptideSequence = getPeptideSequence(proteinSequence);
		
		for (int i = 0; i < peptideSequence.size(); i++) {
			List<ArrayList<Double>> listAminoMass = new ArrayList<ArrayList<Double>>();
			List<Double> resultPeptideMass = new ArrayList<Double>();
			List<Double> result = new ArrayList<Double>();
			listAminoMass = aminoAcidPeptide(peptideSequence.get(i), flag);
			result = GeneratePermutations(listAminoMass, resultPeptideMass, 0, current);
			for (int j = 0; j < result.size(); j++) {
				result.set(j, (result.get(j) + mWeight));
			}
			doubleResult.add((ArrayList<Double>) result);
		}
		
		return (ArrayList<ArrayList<Double>>) doubleResult;
	}
	
	public static List<ArrayList<Double>> aminoAcidPeptide(String peptideSequence, int flag) {
		
		char charPeptide[] = peptideSequence.toCharArray();
		
		List<ArrayList<Double>> listAminoMass = new ArrayList<ArrayList<Double>>();
		
		for (int i = 0; i < peptideSequence.length(); i++) {
			char temp = charPeptide[i];
			
			switch (temp) {
				
				case 'A': {
					List<Double> result = new ArrayList<Double>();
					int size;
					if (flag == 1)
						size = AminoAcidMasses.A.pMass.size() - 1;
					else
						size = AminoAcidMasses.A.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.A.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'R': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.R.pMass.size() - 1;
					else
						size = AminoAcidMasses.R.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.R.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'N': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.N.pMass.size() - 1;
					else
						size = AminoAcidMasses.N.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.N.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'D': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.D.pMass.size() - 1;
					else
						size = AminoAcidMasses.D.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.D.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'C': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.C.pMass.size() - 1;
					else
						size = AminoAcidMasses.C.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.C.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				case 'E': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.E.pMass.size() - 1;
					else
						size = AminoAcidMasses.E.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.E.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'Q': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.Q.pMass.size() - 1;
					else
						size = AminoAcidMasses.Q.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.Q.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'G': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.G.pMass.size() - 1;
					else
						size = AminoAcidMasses.G.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.G.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'H': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.H.pMass.size() - 1;
					else
						size = AminoAcidMasses.H.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.H.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'I': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.I.pMass.size() - 1;
					else
						size = AminoAcidMasses.I.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.I.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'L': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.L.pMass.size() - 1;
					else
						size = AminoAcidMasses.L.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.L.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'K': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.K.pMass.size() - 1;
					else
						size = AminoAcidMasses.K.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.K.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'M': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.M.pMass.size() - 1;
					else
						size = AminoAcidMasses.M.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.M.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'F': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.F.pMass.size() - 1;
					else
						size = AminoAcidMasses.F.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.F.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'P': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.P.pMass.size() - 1;
					else
						size = AminoAcidMasses.P.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.P.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'S': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.S.pMass.size() - 1;
					else
						size = AminoAcidMasses.S.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.S.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'T': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.T.pMass.size() - 1;
					else
						size = AminoAcidMasses.T.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.T.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'W': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.W.pMass.size() - 1;
					else
						size = AminoAcidMasses.W.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.W.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'Y': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.Y.pMass.size() - 1;
					else
						size = AminoAcidMasses.Y.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.Y.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				case 'V': {
					int size;
					List<Double> result = new ArrayList<Double>();
					if (flag == 1)
						size = AminoAcidMasses.V.pMass.size() - 1;
					else
						size = AminoAcidMasses.V.mass.size() - 1;
					for (int j = 0; j <= size; j++) {
						result.add(AminoAcidMasses.V.mass(flag).get(j));
					}
					listAminoMass.add(new ArrayList<Double>(result));
					break;
				}
				
				default: {
					System.out.println("UNKNOWN CHARACTER FOUND");
				}
			}
		}
		// System.out.println(listAminoMass);
		return listAminoMass;
	}
	
	public static List<Double> GeneratePermutations(List<ArrayList<Double>> listAminoMass, List<Double> result,
			int depth, double current) {
		if (depth == listAminoMass.size()) {
			result.add(current);
			return result;
		}
		
		for (int i = 0; i < listAminoMass.get(depth).size(); ++i) {
			GeneratePermutations(listAminoMass, result, depth + 1, current + listAminoMass.get(depth).get(i));
		}
		return result;
	}
}
