/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.rio.helpers;

import org.eclipse.rdf4j.rio.RioSetting;

/**
 * A class encapsulating the basic writer settings that most writers may support.
 * 
 * @author Peter Ansell
 */
public class BasicWriterSettings {

	/**
	 * Boolean setting for writer to determine whether pretty printing is preferred.
	 * <p>
	 * Defaults to true
	 */
	public static final RioSetting<Boolean> PRETTY_PRINT = new RioSettingImpl<Boolean>(
			"org.eclipse.rdf4j.rio.prettyprint", "Pretty print", Boolean.TRUE);

	/**
	 * Inline blanks nodes by their value and don't write any blank node labels when this setting is true.
	 * This setting should only be used when blank nodes never appear in the context and there are no blank
	 * node cycles.
	 * <p>
	 * WARNING: This setting requires all triples to be processed before being written and could use a lot of
	 * memory in the process and should be set to false for large RDF files.
	 * <p>
	 * Defaults to false.
	 *
	 * @since 2.3
	 */
	public static final RioSetting<Boolean> INLINE_BLANK_NODES = new RioSettingImpl<Boolean>(
			"org.eclipse.rdf4j.rio.inlineblanknodes",
			"Use blank node property lists, collections, and anonymous nodes instead of blank node labels",
			Boolean.FALSE);

	/**
	 * Boolean setting for writer to determine whether it should remove the xsd:string datatype from literals
	 * and represent them as RDF-1.0 Plain Literals.
	 * <p>
	 * In RDF-1.1, all literals that would have been Plain Literals in RDF-1.0 will be typed as xsd:string
	 * internally.
	 * <p>
	 * Defaults to true to allow for backwards compatibility without enforcing it.
	 */
	public static final RioSetting<Boolean> XSD_STRING_TO_PLAIN_LITERAL = new RioSettingImpl<Boolean>(
			"org.eclipse.rdf4j.rio.rdf10plainliterals", "RDF-1.0 compatible Plain Literals", Boolean.TRUE);

	/**
	 * Boolean setting for writer to determine whether it should omit the rdf:langString datatype from
	 * language literals when serialising them.
	 * <p>
	 * In RDF-1.1, all RDF-1.0 Language Literals are typed using rdf:langString in the abstract model, but
	 * this datatype is not necessary for concrete syntaxes.
	 * <p>
	 * In most concrete syntaxes it is either syntactically invalid or semantically ambiguous to have a
	 * language tagged literal with an explicit datatype. In those cases this setting will not be used, and
	 * the rdf:langString datatype will not be attached to language tagged literals.
	 * <p>
	 * In particular, in RDF/XML, if rdf:langString is serialised, the language tag may not be retained when
	 * the document is parsed due to the precedence rule in RDF/XML for datatype over language.
	 * <p>
	 * Defaults to true as rdf:langString was not previously used, and should not be commonly required.
	 */
	public static final RioSetting<Boolean> RDF_LANGSTRING_TO_LANG_LITERAL = new RioSettingImpl<Boolean>(
			"org.eclipse.rdf4j.rio.rdf10languageliterals", "RDF-1.0 compatible Language Literals",
			Boolean.TRUE);

	/**
	 * Boolean setting for writer to determine whether it should include a base directive.
	 * <p>
	 * Defaults to true
	 */
	public static final RioSetting<Boolean> BASE_DIRECTIVE = new RioSettingImpl<Boolean>(
			"org.eclipse.rdf4j.rio.basedirective", "Serialize base directive", Boolean.TRUE);

	/**
	 * Private default constructor.
	 */
	private BasicWriterSettings() {
	}

}
