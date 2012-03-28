package lt.itdbaltics.unifi.gateway.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import net.sf.flatpack.DataError;
import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;

public class UnmarshalMokesisTest {
	public static void main(String[] args) throws Exception {
		final String mapping = getDefaultMapping();
		final String data = getDefaultDataFile();
		parse(mapping, data);
	}

	public static String getDefaultDataFile() {
		return "sample-mokesis.txt";
	}

	public static String getDefaultMapping() {
		return "MokesisDelimited.pzmap.xml";
	}

	public static void parse(final String mapping, final String data)
			throws Exception {
		InputStream mappingIs = UnmarshalMokesisTest.class.getClassLoader()
				.getResourceAsStream(mapping);
		InputStream dataIs = UnmarshalMokesisTest.class.getClassLoader()
				.getResourceAsStream(data);

		final Parser pzparser = DefaultParserFactory.getInstance()
				.newDelimitedParser(
						new BufferedReader(new InputStreamReader(mappingIs)),
						new BufferedReader(new InputStreamReader(dataIs, "windows-1257")),
						'\t', '\0', false);
		final DataSet ds = pzparser.parse();

		final String[] colNames = ds.getColumns();

		while (ds.next()) {
			for (int i = 0; i < colNames.length; i++) {
				System.out.println("COLUMN NAME: " + colNames[i] + " VALUE: "
						+ ds.getString(colNames[i]));
			}

			System.out
					.println("===========================================================================");
		}

		if (ds.getErrors() != null && ds.getErrors().size() > 0) {
			System.out.println("<<<<FOUND ERRORS IN FILE>>>>");
			final Iterator<?> pzerrors = ds.getErrors().iterator();
			while (pzerrors.hasNext()) {
				final DataError error = (DataError) pzerrors.next();
				System.out.println("Error Msg: " + error.getErrorDesc()
						+ " line no: " + error.getLineNo());
			}

		}

	}
}
