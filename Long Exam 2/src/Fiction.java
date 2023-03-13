public class Fiction extends Book {

    public Fiction(String bookTitle){ 
        super(bookTitle);
        setPrice();
        }
    
        @Override
        public void setPrice() {
            super.bookPrice = 249.90;
        }
        
}
