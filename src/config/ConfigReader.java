package config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class ConfigReader {
	public static void main(String[] args) throws IOException {
		Config config = new Config();
		config.getTeams().add(new Team("Mitoza", "MITOZA"));
		config.getTeams().add(new Team("Moc", "MOC"));

		XStream xstream = new XStream();
		FileWriter fw = new FileWriter("D:/branchsentry/config.xml");
		BufferedWriter writer = new BufferedWriter(fw);
		xstream.toXML(config, writer);
		System.out.println("Done");
		Config config2 = (Config) xstream.fromXML(new File("D:/branchsentry/config.xml"));
		System.out.println(config2);
	}
}
