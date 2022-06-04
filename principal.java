import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) {
		String[] szOpciones = { "Conversor de moneda", "Conversor de temperatura", "Salir" };
		String szOpcionElegida = "";
		float nDineroOrigen = 0;

		while (szOpcionElegida != "Salir" && szOpcionElegida != null) {
			szOpcionElegida = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menú",
					JOptionPane.QUESTION_MESSAGE, null, szOpciones, szOpciones[0]);
			if (szOpcionElegida == szOpciones[0]) {
				nDineroOrigen = dineroOrigen();
				if (nDineroOrigen >= 0) {
					if (convertirMoneda(nDineroOrigen)) {
						int nConfirmar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
						if (nConfirmar != 0) {
							break;
						}
					}
				}
				;
			}
		}
		JOptionPane.showMessageDialog(null, "Programa finalizado.");
	}

	public static float dineroOrigen() {
		String szImporte = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir");
		float nImporte = 0;
		if (esFloat(szImporte)) {
			nImporte = Float.parseFloat(szImporte);
			System.out.println(nImporte);
			return nImporte;
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
			return -1;
		}

	}

	public static boolean convertirMoneda(float nImporte) {

		boolean bConversionRealizada = false;
		String[] szOpciones = { "De pesos a dólares", "De pesos a euros", "De pesos a libras", "De pesos a yens",
				"De pesos a wons", "De dólares a pesos", "De euros a pesos", "De libras a pesos" };
		double[] nRatios = { 0.0083, 0.0077, 0.0066, 1.08, 10.37, 120.67, 129.35, 150.70 };
		String[] szMonedaDestino = { "dólares", "euros", "libras", "yens", "wons", "pesos", "pesos", "pesos" };
		int nOpcionElegida = -1;
		double nRatio = 0;
		double nResultado;

		String szOpcionElegida = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversión", "Menú",
				JOptionPane.QUESTION_MESSAGE, null, szOpciones, szOpciones[0]);
		System.out.println(szOpcionElegida);
		if (szOpcionElegida != null) {

			for (int j = 0; j < szOpciones.length; j++) {
				if (szOpciones[j] == szOpcionElegida) {
					nOpcionElegida = j;
				}
			}

			nRatio = nRatios[nOpcionElegida];

			if (nRatio != 0) {
				System.out.println("Ratio de convesión: " + nRatio);
				nResultado = nImporte * nRatio;
				JOptionPane.showMessageDialog(null, "El resultado de la conversión es " + (float) nResultado + " "
						+ szMonedaDestino[nOpcionElegida]);
				bConversionRealizada = true;
			}
		}
		return bConversionRealizada;

	}

	public static boolean esFloat(String szCadena) {
		float nRevisado = 0;
		if (szCadena == null)
			return false;
		try {
			nRevisado = Float.parseFloat(szCadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
