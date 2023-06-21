package model.Mensajes;

public class MensajeVo {
    
        //Atributos
        private int idMensaje;
        private String img;
        private String video;
        private String mensaje;
        private String estado;
        
        
        //Metodos constructores
        public MensajeVo(){}
        
        public MensajeVo(int idMensaje, String img, String video, String mensaje, String estado) {
            this.idMensaje=idMensaje;
            this.img = img;
            this.mensaje = mensaje;
            this.estado = estado;
        }
        //Metodos Accesores

        public int getIdMensaje() {
            return idMensaje;
        }

        public void setIdMensaje(int idMensaje) {
            this.idMensaje = idMensaje;
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
