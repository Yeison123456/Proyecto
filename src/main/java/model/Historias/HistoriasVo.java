package model.Historias;

public class HistoriasVo {


    //Atributos
        private int idHistoria;
        private String img;
        private String video;
        private String mensaje;
        private String estado;
        
        
        //Metodos constructores
        public HistoriasVo(){}
        
        public HistoriasVo(int idHistoria, String img, String video, String mensaje, String estado) {
            this.idHistoria=idHistoria;
            this.img = img;
            this.mensaje = mensaje;
            this.estado = estado;
        }
        //Metodos Accesores

        public int getIdHistoria() {
            return idHistoria;
        }

        public void setIdHistoria(int idHistoria) {
            this.idHistoria = idHistoria;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
}
