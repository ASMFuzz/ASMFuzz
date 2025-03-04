/*
 * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package jdk.javadoc.internal.doclets.toolkit.taglets;

import java.util.EnumSet;
import java.util.List;
import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.SpecTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.CommentHelper;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input;
import jdk.javadoc.internal.doclets.toolkit.util.Utils;

/**
 * A taglet that represents the {@code @spec} tag.
 */
public class SpecTaglet extends BaseTaglet implements InheritableTaglet {

    public SpecTaglet() {
        super(DocTree.Kind.SPEC, true, EnumSet.allOf(Location.class));
    }

    @Override
    public boolean isBlockTag() {
        return true;
    }

    @Override
    public void inherit(Input input, DocFinder.Output output) {
        List<? extends SpecTree> tags = input.utils.getSpecTrees(input.element);
        if (!tags.isEmpty()) {
            CommentHelper ch =  input.utils.getCommentHelper(input.element);
            output.holder = input.element;
            output.holderTag = tags.get(0);
            output.inlineTags = input.isFirstSentence
                    ? ch.getFirstSentenceTrees(output.holderTag)
                    : ch.getTags(output.holderTag);
        }
    }

    @Override
    public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
        Utils utils = writer.configuration().utils;
        List<? extends SpecTree> tags = utils.getSpecTrees(holder);
        Element e = holder;
        if (tags.isEmpty() && utils.isExecutableElement(holder)) {
            Input input = new Input(utils, holder, this);
            DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
            if (inheritedDoc.holder != null) {
                tags = utils.getSpecTrees(inheritedDoc.holder);
                e = inheritedDoc.holder;
            }
        }
        return writer.specTagOutput(e, tags);
    }
}
