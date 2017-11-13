package enumerate;

    public enum EnumGradeProduct {
        first("1", 1),
        second("2", 2),
        third("3", 3);

        private String nameEnum;
        private int idEnum;

        EnumGradeProduct(String nameEnum, int idEnum) {
            this.nameEnum = nameEnum;
            this.idEnum = idEnum;


        }

        public String getNameEnum() {
            return nameEnum;
        }

        public int getIdEnum() {
            return idEnum;
        }
    }
