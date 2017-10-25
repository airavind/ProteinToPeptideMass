package permethylationmasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AminoAcidMasses {
//	@formatter:off
	G('G', "Glycine", Arrays.asList(57.02146),  Arrays.asList(102.0555)), 
	A('A', "Alanine", Arrays.asList(71.03711),  Arrays.asList(116.0711)), 
	S('S', "Serine", Arrays.asList(87.03203),  Arrays.asList(115.0633, 83.0371, 95.0497)), 
	T('T', "Threonine", Arrays.asList(101.04768), Arrays.asList(129.0790, 97.0528)), 
	C('C', "Cysteine", Arrays.asList(103.00919), Arrays.asList(202.0776,83.0371)), 
	V('V', "Valine", Arrays.asList(99.06841),  Arrays.asList(113.0841)), 
	L('L', "Leucine", Arrays.asList(113.08406), Arrays.asList(127.0997)), 
	I('I', "Isoleucine", Arrays.asList(113.08406), Arrays.asList(127.0997)), 
	M('M', "Methionine", Arrays.asList(131.04049), Arrays.asList(97.0528)), 
	P('P', "Proline", Arrays.asList(97.05276),  Arrays.asList(174.0766)), 
	F('F', "Phenyl alanine", Arrays.asList(147.06841), Arrays.asList(161.0841)), 
	Y('Y', "Tyrosine", Arrays.asList(163.06333), Arrays.asList(191.0946)), 
	W('W', "Tryptophan", Arrays.asList(186.07931), Arrays.asList(216.1263)), 
	D('D', "Aspartic acid", Arrays.asList(115.02694), Arrays.asList(143.0582)), 
	E('E', "Glutamic acid", Arrays.asList(129.04259), Arrays.asList(157.0739)), 
	N('N', "Asparagine", Arrays.asList(114.04293), Arrays.asList(156.0899)), 
	Q('Q', "Glutamine", Arrays.asList(128.05858), Arrays.asList( 170.1055)), 
	H('H', "Histidine", Arrays.asList(137.05891), Arrays.asList(165.0902)), 
	K('K', "Lysine", Arrays.asList(128.09496), Arrays.asList(185.1648)), 
	R('R', "Arginine", Arrays.asList(156.10111), Arrays.asList(226.1794));
// @formatter:on
	
	public final char letter;
	public final String aminoAcidName;
	public List<Double> mass = new ArrayList<Double>();
	public List<Double> pMass = new ArrayList<Double>();
	
	AminoAcidMasses(char letter, String aminoAcidName, List<Double> mass, List<Double> pMass) {
		this.letter = letter;
		this.aminoAcidName = aminoAcidName;
		this.mass = mass;
		this.pMass = pMass;
	}
	
	public char letter() {
		return letter;
	}
	
	public String aminoAcidName() {
		return aminoAcidName;
	}
	
	public List<Double> mass(int flag) {
		if (flag == 1)
			return pMass;
		else
			return mass;
	}
	
}
