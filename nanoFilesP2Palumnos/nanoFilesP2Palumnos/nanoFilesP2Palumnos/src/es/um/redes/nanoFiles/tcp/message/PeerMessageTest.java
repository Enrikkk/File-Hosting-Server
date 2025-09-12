package es.um.redes.nanoFiles.tcp.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PeerMessageTest {

	public static void main(String[] args) throws IOException {
//		String nombreArchivo = "peermsg_pru01_ambiguousname.bin";
//		DataOutputStream fos = new DataOutputStream(new FileOutputStream(nombreArchivo));

		/*
		 * TODO: Probar a crear diferentes tipos de mensajes (con los opcodes válidos
		 * definidos en PeerMessageOps), estableciendo los atributos adecuados a cada
		 * tipo de mensaje. Luego, escribir el mensaje a un fichero con
		 * writeMessageToOutputStream para comprobar que readMessageFromInputStream
		 * construye un mensaje idéntico al original.
		 */
//		PeerMessage msgOut = new PeerMessage();
//		msgOut.writeMessageToOutputStream(fos);
//
//		DataInputStream fis = new DataInputStream(new FileInputStream(nombreArchivo));
//		PeerMessage msgIn = PeerMessage.readMessageFromInputStream((DataInputStream) fis);
		/*
		 * TODO: Comprobar que coinciden los valores de los atributos relevantes al tipo
		 * de mensaje en ambos mensajes (msgOut y msgIn), empezando por el opcode.
		 */

		/*
		 * if (msgOut.getOpcode() != msgIn.getOpcode()) {
		 * System.err.println("Opcode does not match!"); }
		 */

		// Prueba nº 1: mensaje "ambiguousName"

		String nombreArchivo = "peermsg_pru01_ambiguousname.bin";
		DataOutputStream fos = new DataOutputStream(new FileOutputStream(nombreArchivo));
		PeerMessage msgOut = new PeerMessage(PeerMessageOps.OPCODE_AMBIGUOUS_NAME);
		msgOut.writeMessageToOutputStream(fos);
		DataInputStream fis = new DataInputStream(new FileInputStream(nombreArchivo));
		PeerMessage msgIn = PeerMessage.readMessageFromInputStream((DataInputStream) fis);
		if (msgOut.getOpcode() == msgIn.getOpcode()) {
			System.out.println("PRUEBA nº 1...");
			byte opcode = msgIn.getOpcode();
			System.out.println(
					"opcode = " + Integer.toString(opcode) + " (" + PeerMessageOps.opcodeToOperation(opcode) + ")\n");
		} else {
			System.err.println("Opcode does not match!\n");
		}

		// Prueba nº 2: mensaje "fileNotFound"

		nombreArchivo = "peermsg_pru02_filenotfound.bin";
		fos = new DataOutputStream(new FileOutputStream(nombreArchivo));
		msgOut = new PeerMessage(PeerMessageOps.OPCODE_FILE_NOT_FOUND);
		msgOut.writeMessageToOutputStream(fos);
		fis = new DataInputStream(new FileInputStream(nombreArchivo));
		msgIn = PeerMessage.readMessageFromInputStream((DataInputStream) fis);
		if (msgOut.getOpcode() == msgIn.getOpcode()) {
			System.out.println("PRUEBA nº 2...");
			byte opcode = msgIn.getOpcode();
			System.out.println(
					"opcode = " + Integer.toString(opcode) + " (" + PeerMessageOps.opcodeToOperation(opcode) + ")\n");
		} else {
			System.err.println("Opcode does not match!\n");
		}

		// Prueba nº 3: mensaje "fileMetadata"

		nombreArchivo = "peermsg_pru03_filemetadata.bin";
		fos = new DataOutputStream(new FileOutputStream(nombreArchivo));
		msgOut = new PeerMessage(PeerMessageOps.OPCODE_FILE_METADATA, 119372,"8c09599d886fdfd1607d8e99d053be0499f9219a");
		msgOut.writeMessageToOutputStream(fos);
		fis = new DataInputStream(new FileInputStream(nombreArchivo));
		msgIn = PeerMessage.readMessageFromInputStream((DataInputStream) fis);
		if (msgOut.getOpcode() == msgIn.getOpcode()) {
			System.out.println("PRUEBA nº 3...");
			byte opcode = msgIn.getOpcode();
			System.out.println("opcode = " + Integer.toString(opcode) + " (" + PeerMessageOps.opcodeToOperation(opcode)
					+ ")\n" + "fileSize = " + msgIn.getFileSize() + " bytes\n" + "fileHash = " + msgIn.getFileHash() + "\n");
		} else {
			System.err.println("Opcode does not match!\n");
		}

		// Prueba nº 4: mensaje "downloadFile"

		nombreArchivo = "peermsg_pru04_downloadfile.bin";
		fos = new DataOutputStream(new FileOutputStream(nombreArchivo));
		
		String fileName = "ANEXO I definitivo.docx";
		byte longFileName = (byte) fileName.length();
		
		msgOut = new PeerMessage(PeerMessageOps.OPCODE_DOWNLOAD_FILE, longFileName, fileName);
		msgOut.writeMessageToOutputStream(fos);
		fis = new DataInputStream(new FileInputStream(nombreArchivo));
		msgIn = PeerMessage.readMessageFromInputStream((DataInputStream) fis);
		if (msgOut.getOpcode() == msgIn.getOpcode()) {
		    System.out.println("PRUEBA nº 4...");
		    byte opcode = msgIn.getOpcode();
		    System.out.println("opcode = " + Integer.toString(opcode) + " (" + PeerMessageOps.opcodeToOperation(opcode) + ")");
		    System.out.println("longFileName = " + msgIn.getLongFileName() + " characters");
		    System.out.println("fileName = " + msgIn.getFileName());
		} else {
			System.err.println("Opcode does not match!\n");
		}
	}

}
