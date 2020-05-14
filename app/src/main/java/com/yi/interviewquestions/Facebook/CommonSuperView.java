package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.List;

class UIView{
    int value;
    List<UIView> child;
    public UIView(int value, List<UIView> child){
        this.value = value;
        this.child = child;
    }
}

public class CommonSuperView {

    public UIView getCommonView(UIView root, UIView a, UIView b){
        if(root.value == a.value || root.value == b.value) return root;
        if(root == null) return null;

        List<UIView> uiViews = new ArrayList<>();
        for(int i = 0; i<root.child.size(); i++){
            UIView temp = getCommonView(root.child.get(i),a,b);
            if(temp!=null)uiViews.add(temp);

        }

        if(uiViews.size() == 2) return root;
        if(uiViews.size() == 1) return uiViews.get(0);

        return null;
    }

    public static void main(String[] args){
        List<UIView> temp = new ArrayList<>();
        UIView uiView = new UIView(1,temp);
        UIView uiView1 = new UIView(2,temp);
        UIView uiView2 = new UIView(3,temp);
        UIView uiView3 = new UIView(4,temp);
        UIView uiView4 = new UIView(5,temp);
        UIView uiView5 = new UIView(6,temp);
        UIView uiView6 = new UIView(7,temp);
        UIView uiView7 = new UIView(8,temp);
        UIView uiView8 = new UIView(9,temp);
        UIView uiView9 = new UIView(10,temp);
        UIView uiView10 = new UIView(11,temp);


        List<UIView> a = new ArrayList<>();
        a.add(uiView1);a.add(uiView2);a.add(uiView3);
        uiView.child = a;

        List<UIView> d = new ArrayList<>();
        d.add(uiView4);d.add(uiView5);
        uiView1.child = d;

        List<UIView> b = new ArrayList<>();
        b.add(uiView6);b.add(uiView7);
        uiView2.child = b;

        List<UIView> c = new ArrayList<>();
        c.add(uiView8); c.add(uiView9); c.add(uiView10);
        uiView7.child =c;


        CommonSuperView commonSuperView = new CommonSuperView();
        UIView common = commonSuperView.getCommonView(uiView,uiView4,uiView1);
        System.out.println(common.value);
    }

}
