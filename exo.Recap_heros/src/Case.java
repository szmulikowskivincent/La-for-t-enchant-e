class Case {
    // Propriétés pour représenter le contenu et la taille de la case
    private String contenu;
    private int taille;
    public Case(String contenu, int taille) {
        this.contenu = contenu;
        this.taille = taille;
    }
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public int getTaille() {
        return taille;
    }
    public void setTaille(int taille) {
        this.taille = taille;
    }
}


