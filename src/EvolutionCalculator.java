public class EvolutionCalculator {
	
	/**
	 * max password length = 4 * (cpu1 + cpu2) * (firewall level + 1) * (bounces + 1)
	 * @param cpu1
	 * @param cpu2
	 * @param firewall
	 * @return
	 */
	public String getPasswordLenght(int cpu1, int cpu2, int firewall, int maxBounces){
		int multiplier = 4;
		StringBuilder finalString = new StringBuilder("");
		for(int i = 0; i <= maxBounces; i++){
			int bounces = i;
			int mpl = multiplier * (cpu1 + cpu2) * (firewall + 1) * (bounces + 1);
			finalString.append(bounces + " bounces: " + mpl + " characters\n");
		}
		return finalString.toString();
	}
	
	/**
	 * max encryption size = 128 * (cpu1 + cpu2) * (firewall level + 1) * (bounces + 1)
	 * @param cpu1
	 * @param cpu2
	 * @param firewall
	 * @return
	 */
	public String getEncryptionSize(int cpu1, int cpu2, int firewall, int maxBounces){
		int multiplier = 128;
		StringBuilder finalString = new StringBuilder("");
		for(int i = 0; i <= maxBounces; i++){
			int bounces = i;
			int maxEncryption = multiplier * (cpu1 + cpu2) * (firewall + 1) * (bounces + 1);
			finalString.append(bounces + " bounces: " + maxEncryption + " bits\n");
		}
		return finalString.toString();
	}
	
	/**
	 * transfer amount = 1000 * (modem speed) * (firewall level + 1) * (bounces + 1)
	 * @param modem
	 * @param firewall
	 * @return
	 */
	public String getTransfers(int modem, int firewall, int maxBounces){
		int multiplier = 1000;
		StringBuilder finalString = new StringBuilder("");
		for(int i = 0; i <= maxBounces; i++){
			int bounces = i;
			int maxAmount = multiplier * (modem) * (firewall + 1) * (bounces + 1);
			finalString.append(bounces + " bounces: $" + maxAmount + "\n");
		}
		return finalString.toString();
	}
}