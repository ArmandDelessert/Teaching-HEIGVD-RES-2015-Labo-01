package ch.heigvd.res.lab01.impl;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
		String[] strings = new String[2];

		strings[0] = "";
		strings[1] = lines;

		char current;
		boolean windowsEndofLine = false;
		for (int i = 0; i < lines.length() ; i++)
		{
				current = lines.charAt(i);
				if (current == '\n' || current == '\r')
				{
						windowsEndofLine = (current == '\r' && i < lines.length() - 1 && lines.charAt(i + 1) == '\n');
						strings[0] = lines.substring(0, i) + current + (windowsEndofLine? "\n" : "");
						strings[1] = lines.substring(i + (windowsEndofLine? 2 : 1));
						break;
				}
		}

		return strings;
  }

}
