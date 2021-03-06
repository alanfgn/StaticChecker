package br.ucsal.eq02.entity;

import br.ucsal.eq02.entity.Atom;
import br.ucsal.eq02.entity.AtomType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AtomTable {

    private List<Atom> atoms;

    public AtomTable(List<Atom> atoms) {
        this.atoms = atoms;
    }

    public List<Atom> getAtoms(String lexeme) {

        List<Atom> atoms = new ArrayList<>();

        for (Atom atom : this.atoms) {
            if (lexeme.matches(atom.getRegex())) {
                atoms.add(atom);
            }
        }

        return atoms;
    }

    // Maybe not
    public boolean haveAtom(String lexeme) {
        return this.getAtoms(lexeme).size() > 0;
    }

    public List<Atom> getAtomsByCodes(String[] codes) {
        return this.atoms.stream().filter(x -> Arrays.stream(codes).anyMatch(y -> y.equals(x.getCode())))
                .collect(Collectors.toList());
    }

    public Atom getAtomByCode(String code) {
        return getAtomsByCodes(new String[]{code}).get(0);
    }

    public List<Atom> getAtomsForType(AtomType atomType) {
        return this.atoms.stream().filter(x -> x.getAtomType().equals(atomType)).collect(Collectors.toList());
    }

    public void appendListAtoms(List<Atom> atoms) {
        this.atoms.addAll(atoms);
    }
}
