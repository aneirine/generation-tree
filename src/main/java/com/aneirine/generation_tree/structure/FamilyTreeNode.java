package com.aneirine.generation_tree.structure;

import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FamilyTreeNode implements Iterable<FamilyTreeNode> {

    private List<FamilyMember> data;
    private FamilyTreeNode parent;
    private List<FamilyTreeNode> children;

    public FamilyTreeNode(List<FamilyMember> data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public FamilyTreeNode addChild(List<FamilyMember> childData) {
        FamilyTreeNode childNode = new FamilyTreeNode(childData);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }


    public List<FamilyMember> getData() {
        return data;
    }

    public void setData(List<FamilyMember> data) {
        this.data = data;
    }

    public FamilyTreeNode getParent() {
        return parent;
    }

    public void setParent(FamilyTreeNode parent) {
        this.parent = parent;
    }

    public List<FamilyTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<FamilyTreeNode> children) {
        this.children = children;
    }

    @Override
    public Iterator<FamilyTreeNode> iterator() {
        return null;
    }
}