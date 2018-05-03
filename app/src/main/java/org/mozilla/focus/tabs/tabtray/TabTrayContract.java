/* -*- Mode: Java; c-basic-offset: 4; tab-width: 4; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.tabs.tabtray;

import org.mozilla.focus.tabs.Tab;

import java.util.List;

class TabTrayContract {
    interface Presenter {
        void viewReady();
        void tabClicked(int tabPosition);
        void tabCloseClicked(int tabPosition);
        void tabTrayClosed();
        void closeAllTabs();
    }

    interface View {
        void initData(List<Tab> newTabs, Tab newFocusedTab);
        void refreshData(List<Tab> newTabs, Tab newFocusedTab);
        void refreshTabData(Tab tab);
        void showFocusedTab(int tabPosition);
        void tabSwitched(int tabPosition);
        void closeTabTray();
        void navigateToHome();
    }

    interface Model {
        void loadTabs(OnLoadCompleteListener listener);
        List<Tab> getTabs();

        Tab getFocusedTab();

        void switchTab(int tabPosition);
        void removeTab(int tabPosition);
        void clearTabs();

        void subscribe(Observer observer);
        void unsubscribe();

        interface OnLoadCompleteListener {
            void onLoadComplete();
        }

        interface Observer {
            void onUpdate(List<Tab> newTabs);
            void onTabUpdate(Tab tab);
        }
    }
}
