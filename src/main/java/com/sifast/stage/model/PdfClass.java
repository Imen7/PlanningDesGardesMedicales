package com.sifast.stage.model;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sifast.stage.ihm.AjouterPlanning;
import com.sifast.stage.ihm.MembresDeGarde;



public class PdfClass {
	public static void main(String arg[]) throws Exception {
		
		
		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream("planning.pdf"));
		document.open();
		
		document.add(new Paragraph("Planning des Gardes Medicales"));
		document.add(new Paragraph(AjouterPlanning.plan.getNomPlanning()));
		document.add(new Paragraph("du " + String.format("%1$td/%1$tm/%1$tY", AjouterPlanning.plan.getDateDebut().getDate()) + " au "
				+ String.format("%1$td/%1$tm/%1$tY", AjouterPlanning.plan.getDateFin().getDate())));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		
		
		
		Boolean test2 = true;
		int indice = 0;
		for (Object elem1 : MembresDeGarde.dates) {
			test2 = true;
			while (test2) {
				Docteur docteur = MembresDeGarde.docteurs.get(indice % MembresDeGarde.docteurs.size());
				if (!(docteur.getPreference().containsKey(elem1))) // champ
																	// vide=
																	// dispo
				{
					document.add(new Paragraph("Le " + elem1 + ", le docteur:  " + MembresDeGarde.docteurs.get(indice % MembresDeGarde.docteurs.size()).getNom() + " en garde "));
					indice++;
					break;
				}
				if (docteur.getPreference().get(elem1).equals(PrefEnum.not_dispo)) {
					indice++;
				}
				if (docteur.getPreference().get(elem1).equals(PrefEnum.dispo_but)) {
					Boolean test = false;
					// recherche du docteur disponible
					for (int i = 0; i < MembresDeGarde.docteurs.size(); i++) {
						if (!(MembresDeGarde.docteurs.get(i).getPreference().containsKey(elem1))) {
							document.add(new Paragraph("Le " + elem1 + ", le docteur:  " + MembresDeGarde.docteurs.get(i).getNom() + " en garde "));
							test = true;
							indice++;
							test2 = false;
							break;
						}
					}
					if (!test) {
						document.add(new Paragraph("Le " + elem1 + ", le docteur: " + MembresDeGarde.docteurs.get(indice % MembresDeGarde.docteurs.size()).getNom() + " en garde "));
						indice++;
						break;
					}
					break;
				}
			}
		}
	
		document.close();

		try {

			if ((new File(
					"d:\\Projets\\PlanningDesGardesMedicales\\planning.pdf"))
					.exists()) {

				Process p = Runtime
						.getRuntime()
						.exec("rundll32 url.dll,FileProtocolHandler d:\\Projets\\PlanningDesGardesMedicales\\planning.pdf");
				p.waitFor();

			} else {

				System.out.println("File is not exists");

			}

			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
