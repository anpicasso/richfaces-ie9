/**
 * License Agreement.
 *
 * Rich Faces - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */
package org.ajax4jsf.tests;

import java.util.ArrayList;
import java.util.List;

import org.ajax4jsf.renderkit.RendererUtils.HTML;
import org.apache.commons.lang.StringUtils;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlScript;

/**
 * @author Maksim Kaszynski
 *
 */
public final class HtmlTestUtils {
	private HtmlTestUtils() {
	}
	
	/**
	 * Extract list of all &lt;script&gt; elements' src attributes
	 * @param page
	 * @return
	 */
    @SuppressWarnings("unchecked")
    public static List<String> extractScriptSources(HtmlPage page) {
    	List<HtmlScript> list = 
    		page.getDocumentHtmlElement().getHtmlElementsByTagName(HTML.SCRIPT_ELEM);
    	List<String> sources = new ArrayList<String>();
    	for (HtmlScript htmlScript : list) {
			String srcAttribute = htmlScript.getSrcAttribute();
			if (StringUtils.isNotBlank(srcAttribute)) {
				sources.add(srcAttribute);
			}
		}
    	return sources;
    }


}
