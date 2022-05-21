package fr.nohas.go4food.resto;

public class Category {
        private String name,image;
        public Category(){
        }
        public Category(String name, String image){
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImage(String image) {
            this.image = image;
        }

}
