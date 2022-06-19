package com.mydomain.project_server.routes.V1;

public class ApiV1Routes {

    private static final String baseSitePanel = "api/v1/site/panel";

    //#region gate
    public static class Gate {

        //api/v1/site/panel/users/{userId}/gates
        //post
        public static final String addGate = baseSitePanel + "/users/{userId}/gates";

        //api/v1/site/panel/users/{userId}/gates
        //get
        public static final String getGates = baseSitePanel + "/users/{userId}/gates";

        //api/v1/site/panel/users/{userId}/gates/{id}
        //get
        public static final String getGate = baseSitePanel + "/users/{userId}/gates/{id}";

        //api/v1/site/panel/users/{userId}/gates/{id}
        //put
        public static final String updateGate = baseSitePanel + "/users/{userId}/gates/{id}";

        //api/v1/site/panel/users/{userId}/gates/{id}/active
        //put
        public static final String activeDirectGate = baseSitePanel + "/users/{userId}/gates/{id}/active";
    }
    //#endregion

    //#region easyPay
    public static class EasyPay {

        //api/v1/site/panel/users/{userId}/easyPays
        //post
        public static final String addEasyPay = baseSitePanel + "/users/{userId}/easyPays";

        //api/v1/site/panel/users/{userId}/easyPays
        //get
        public static final String getEasyPays = baseSitePanel + "/users/{userId}/easyPays";

        //api/v1/site/panel/users/{userId}/easyPays/{id}
        //get
        public static final String getEasyPay = baseSitePanel + "/users/{userId}/easyPays/{id}";

        //api/v1/site/panel/users/{userId}/easyPays/{id}
        //put
        public static final String updateEasyPay = baseSitePanel + "/users/{userId}/easyPays/{id}";

        //api/v1/site/panel/users/{userId}/easyPays/{id}
        //delete
        public static final String deleteEasyPay = baseSitePanel + "/users/{userId}/easyPays/{id}";
    }
    //#endregion

    //#region blog
    public static class Blog {

        //api/v1/site/panel/users/{userId}/blogs/upload
        //post
        public static final String uploadBlogImage = baseSitePanel + "/users/{userId}/blogs/upload";


        //api/v1/site/panel/users/{userId}/blogs/delupload
        //get
        public static final String deleteBlogImage = baseSitePanel + "/users/{userId}/blogs/delUpload";


        //api/v1/site/panel/users/{userId}/blogs
        //get
        public static final String getBlogs = baseSitePanel + "/users/{userId}/blogs";

        //api/v1/site/panel/users/{userId}/blog/{id}
        //get
        public static final String getBlog = baseSitePanel + "/users/{userId}/blog/{id}";

        //api/v1/site/panel/users/{userId}/blog/{id}
        //put
        public static final String updateBlog = baseSitePanel + "/users/{userId}/blog/{id}";

        //api/v1/site/panel/users/{userId}/blog
        //post
        public static final String addBlog = baseSitePanel + "/users/{userId}/blog";

        //api/v1/site/panel/users/{userId}/blog/{id}
        //delete
        public static final String deleteBlog = baseSitePanel + "/users/{userId}/blog/{id}";

        //api/v1/site/panel/users/{userId}/blog/{id}
        //put
        public static final String selectBlog = baseSitePanel + "/users/{userId}/blog/{id}/selectBlog";

        //api/v1/site/panel/users/{userId}/blog/{id}
        //delete
        public static final String approveBlog = baseSitePanel + "/users/{userId}/blog/{id}/approveBlog";
    }
    //#endregion

    //#region accountant
    public static class Accountant {

        //api/v1/panel/accountant/
        //get
        public static final String getInventories = baseSitePanel + "/inventories";

        //api/v1/panel/accountant/
        //get
        public static final String getInventoryWallets = baseSitePanel + "/inventories/wallets/{user_id}";


        //api/v1/panel/accountant/
        //get
        public static final String getInventoryBankCard = baseSitePanel + "/inventories/bankCards/{user_id}";

        //api/v1/panel/accountant/
        //patch
        public static final String blockInventoryWallet = baseSitePanel + "/inventories/blockWallet/{wallet_id}";

        //api/v1/panel/accountant/
        //patch
        public static final String approveInventoryWallet = baseSitePanel + "/inventories/approveBankCard/{bankCard_id}";


        //api/v1/panel/accountant/
        //get
        public static final String getWallets = baseSitePanel + "/inventories/allWallets";


        //api/v1/panel/accountant/
        //get
        public static final String getBankCards = baseSitePanel + "/inventories/allBankCards";

    }
    //#endreg

    //region entry
    public static class Entry {

        //api/v1/panel/accountant/
        //get
        public static final String getEntries = baseSitePanel + "/entries";

        //api/v1/panel/accountant/
        //get
        public static final String getEntry = baseSitePanel + "/entries/{entry_id}";

        //api/v1/panel/accountant/
        //post
        public static final String addEntry = baseSitePanel + "/entries";

        //api/v1/panel/accountant/
        //put
        public static final String updateEntry = baseSitePanel + "/entries/{entry_id}";

        //api/v1/panel/accountant/
        //patch
        public static final String approveEntry = baseSitePanel + "/entries/{entry_id}";

        //api/v1/panel/accountant/
        //patch
        public static final String rejectEntry = baseSitePanel + "/entries/{entry_id}";

        //api/v1/panel/accountant/
        //patch
        public static final String pardakhtEntry = baseSitePanel + "/entries/{entry_id}";


        //api/v1/panel/accountant/
        //delete
        public static final String deleteEntry = baseSitePanel + "/entries/{entry_id}";


    }
    //endregion

    //region factor
    public static class Factor {

        public static final String getFactors = baseSitePanel + "/factors";

        public static final String getFactor = baseSitePanel + "/factors/{factor_id}";

        public static final String statusFactor = baseSitePanel + "/factors/{factor_id}";

        public static final String delete = baseSitePanel + "/factors/{factor_id}";


    }
    //endregion




}
